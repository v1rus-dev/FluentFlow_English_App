object AppDependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePluginVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val hiltAndroidGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val kotlinSerializationPlugin = "org.jetbrains.kotlin:kotlin-serialization:${Versions.kotlinVersion}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.sageArgsPluginsVersion}"
}

object Plugins {
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinParcelize = "kotlin-parcelize"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"
    const val dagger = "dagger.hilt.android.plugin"
    const val detekt = "io.gitlab.arturbosch.detekt"
    const val gmsServices = "com.google.gms.google-services"
}

object Versions {

    const val androidGradlePluginVersion = "7.2.2"
    const val googleServicesVersion = "4.3.15"
    const val sageArgsPluginsVersion = "2.5.3"

    const val viewModelVersion = "2.5.1"

    const val kotlinVersion = "1.8.0"
    const val androidCoreVersion = "1.9.0"
    const val appCompatVersion = "1.6.0"
    const val materialVersion: String = "1.7.0"
    const val constraintLayoutVersion: String = "2.1.4"
    const val junitVersion: String = "4.13.2"
    const val junitAndroidVersion: String = "1.1.5"
    const val espressoAndroidVersion: String = "3.5.1"

    const val hiltVersion = "2.44.2"
    const val daggerVersion = "2.44"

    const val roomVersion = "2.5.0"

    const val activityComposeVersion = "1.5.1"
    const val composeViewModelVersion = "2.5.1"

    const val navVersion = "2.5.3"
    const val firebaseBomVersion = "31.2.0"
}

object Dependencies {
    const val coreCtx = "androidx.core:core-ktx:${Versions.androidCoreVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val material = "com.google.android.material:material:${Versions.materialVersion}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelVersion}"

    const val junit = "junit:junit:${Versions.junitVersion}"
    const val junitAndroid = "androidx.test.ext:junit:${Versions.junitAndroidVersion}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoAndroidVersion}"

    const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.roomVersion}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val testRoom = "androidx.room:room-testing:${Versions.roomVersion}"

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navVersion}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navVersion}"
    const val androidTestNavigation = "androidx.navigation:navigation-testing:${Versions.navVersion}"
    const val dinamicFeatureNavigation = "androidx.navigation:navigation-dynamic-features-fragment:${Versions.navVersion}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navVersion}"

    const val firebaseBom = "com.google.firebase:firebase-bom:${Versions.firebaseBomVersion}"
    const val firebaseFirestore = "com.google.firebase:firebase-firestore-ktx"
    const val firebaseAnalytics = "com.google.firebase:firebase-analytics-ktx"

    object Compose {
        const val composeBom = "androidx.compose:compose-bom:2023.01.00"
        const val material = "androidx.compose.material:material"
        const val preview = "androidx.compose.ui:ui-tooling-preview"
        const val debugPreviewTooling = "androidx.compose.ui:ui-tooling"

        const val androidTestJunit = "androidx.compose.ui:ui-test-junit4"
        const val debugManifest = "androidx.compose.ui:ui-test-manifest"

        const val icons = "androidx.compose.material:material-icons-extended"

        const val activityCompose = "androidx.activity:activity-compose:${Versions.activityComposeVersion}"
        const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModelVersion}"
    }

    object Voyager {
        private const val voyagerVersion = "1.0.0-rc03"

        const val navigator = "cafe.adriel.voyager:voyager-navigator:${voyagerVersion}"
        const val bottomSheetNavigator = "cafe.adriel.voyager:voyager-bottom-sheet-navigator:${voyagerVersion}"
        const val tabNavigator = "cafe.adriel.voyager:voyager-tab-navigator:${voyagerVersion}"
        const val transitions = "cafe.adriel.voyager:voyager-transitions:${voyagerVersion}"
        const val viewModelIntegration = "cafe.adriel.voyager:voyager-androidx:${voyagerVersion}"
        const val hilt = "cafe.adriel.voyager:voyager-hilt:${voyagerVersion}"
    }
}