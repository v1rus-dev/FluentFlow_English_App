// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(AppDependencies.androidGradlePlugin)
        classpath(AppDependencies.kotlinGradlePlugin)
        classpath(AppDependencies.hiltAndroidGradlePlugin)
        classpath(AppDependencies.kotlinSerializationPlugin)
        classpath(AppDependencies.googleServices)
        classpath(AppDependencies.safeArgs)
    }
}

@Suppress("JcenterRepositoryObsolete")
allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.google.com")
        jcenter()
    }
}