import com.novoda.gradle.release.PublishExtension

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.novoda.bintray-release")
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

configure<PublishExtension> {
    userOrg = "anoop44"
    groupId = "ss.anoop"
    artifactId = "awesome-edittext"
    publishVersion = "1.0.0"
    desc = "A no-boaring edittext that have a zoom out animation while typing"
    website = "https://github.com/anoop44/AwesomeEditText"
}