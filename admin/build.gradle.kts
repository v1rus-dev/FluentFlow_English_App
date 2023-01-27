plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.safeArgs)
    id(Plugins.dagger)
    id(Plugins.gmsServices)
}

android {
    namespace = "yegor.cheprasov.admin"
    compileSdk = 33

    defaultConfig {
        applicationId = "yegor.cheprasov.fluentflow.admin"
        minSdk = 23
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.0"
    }
}

dependencies {
    implementation(project(":design"))
    implementation(project(":data"))
    implementation(project(":admin_features"))

    implementation(Dependencies.coreCtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)
    implementation(Dependencies.viewModel)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    implementation(Dependencies.Voyager.navigator)
    implementation(Dependencies.Voyager.bottomSheetNavigator)
    implementation(Dependencies.Voyager.tabNavigator)
    implementation(Dependencies.Voyager.transitions)
    implementation(Dependencies.Voyager.viewModelIntegration)
    implementation(Dependencies.Voyager.hilt)

    implementation(platform(Dependencies.Compose.composeBom))
    androidTestImplementation(platform(Dependencies.Compose.composeBom))

    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.activityCompose)
    debugImplementation(Dependencies.Compose.debugPreviewTooling)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseAnalytics)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espresso)
}

kapt {
    correctErrorTypes = true
}