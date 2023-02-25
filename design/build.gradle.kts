plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.dagger)
}

android {
    namespace = "yegor.cheprasov.feature_design"
    compileSdk = 33

    defaultConfig {
        minSdk = 23
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.coreCtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espresso)

    implementation(platform(Dependencies.Compose.composeBom))
    androidTestImplementation(platform(Dependencies.Compose.composeBom))

    implementation(Dependencies.navigationFragment)

    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.preview)
    debugImplementation(Dependencies.Compose.debugPreviewTooling)

    androidTestImplementation(Dependencies.Compose.androidTestJunit)
    debugImplementation(Dependencies.Compose.debugManifest)

    implementation(Dependencies.Compose.icons)
    implementation(Dependencies.Compose.activityCompose)
    implementation(Dependencies.Compose.viewModel)
}

kapt {
    correctErrorTypes = true
}