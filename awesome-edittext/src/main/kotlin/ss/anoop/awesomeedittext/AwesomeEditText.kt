package ss.anoop.awesomeedittext

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.widget.AppCompatEditText
import ss.anoop.awesomeedittext.internal.DefaultAnimatorListener

open class AwesomeEditText : AppCompatEditText {
    private val textPaint = Paint(
        ANTI_ALIAS_FLAG
    )
    private var character: Char? = null

    private var textX = 0f

    private var animationDuration = 300

    private var animator: Animator? = null

    constructor(
        context: Context,
        attributeSet: AttributeSet?,
        defStyleRes: Int
    ) : super(
        context,
        attributeSet,
        defStyleRes
    ) {
        init(attributeSet, defStyleRes)
    }

    constructor(
        context: Context,
        attributeSet: AttributeSet?
    ) : super(context, attributeSet) {
        init(attributeSet, 0)

    }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        if (lengthAfter != 0 &&
            lengthAfter > lengthBefore &&
            text?.isNotBlank() == true
        ) {
            character = text.last()
            animateText()
            textX = getTextX()
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (character != null) {
            canvas.drawText(
                character.toString(),
                textX,
                paddingTop + paint.textSize,
                textPaint
            )
        }
    }

    override fun setTextAlignment(textAlignment: Int) {
        require(textAlignment == TEXT_ALIGNMENT_TEXT_START) {
            "Currently support only text from LTR"
        }
        super.setTextAlignment(textAlignment)
    }

    override fun setLines(lines: Int) {
        require(lines == 1) {
            "Doesn't support multi lines"
        }
        super.setLines(lines)
    }

    override fun setSingleLine(singleLine: Boolean) {
        require(singleLine) {
            "Doesn't support multi lines now"
        }
        super.setSingleLine(singleLine)
    }

    override fun onDetachedFromWindow() {
        animator?.cancel()
        super.onDetachedFromWindow()
    }

    private fun animateText() {
        val sizeAnimator = ValueAnimator.ofFloat(
            height.toFloat(),
            paint.textSize
        ).apply {
            duration = animationDuration.toLong()
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                textPaint.textSize = it.animatedValue as Float
                invalidate()
            }
        }

        val alphaAnimator = ValueAnimator.ofInt(
            0, 255
        ).apply {
            duration = animationDuration.toLong()
            interpolator = DecelerateInterpolator()
            addUpdateListener {
                textPaint.alpha = it.animatedValue as Int
                invalidate()
            }
        }

        animator = AnimatorSet().apply {
            playTogether(
                sizeAnimator, alphaAnimator
            )
            addListener(object : DefaultAnimatorListener() {
                override fun onAnimationEnd(animation: Animator?) {
                    character = null
                    invalidate()
                }
            })
        }.apply { start() }
    }

    private fun getTextX(): Float {
        return paddingStart +
                compoundDrawablePadding +
                paint.measureText(
                    editableText.toString().removeSuffix(character.toString())
                )
    }

    private fun init(attributeSet: AttributeSet?, defStyleRes: Int) {
        textPaint.apply {
            color = currentTextColor
            typeface = paint.typeface
        }
        setSingleLine()
        textAlignment = View.TEXT_ALIGNMENT_TEXT_START
        if(null != attributeSet){
            initAttrs(attributeSet, defStyleRes)
        }
    }

    private fun initAttrs(
        attributeSet: AttributeSet,
        defStyleRes: Int
    ) {
        context.obtainStyledAttributes(
            attributeSet,
            R.styleable.AwesomeEditText,
            0,
            defStyleRes
        ).run {
            animationDuration = getInteger(
                R.styleable.AwesomeEditText_animationDuration,
                animationDuration
            )
            recycle()
        }
    }
}
