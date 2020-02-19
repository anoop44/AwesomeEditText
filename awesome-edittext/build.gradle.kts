plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(29)
    defaultConfig {
        minSdkVersion(17)
        targetSdkVersion(29)
        versionName = "0.1.0"
        versionCode = 10
    }

    sourceSets["main"].java.srcDirs(
        "src/main/kotlin"
    )
}

dependencies {
    implementation(kotlin("stdlib-jdk7", "1.3.61"))
    implementation ("androidx.appcompat:appcompat:1.1.0")
}