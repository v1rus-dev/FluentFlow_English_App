plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
    id(Plugins.dagger)
}

android {
    namespace = "yegor.cheprasov.feature_admin_features"
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {
    implementation(project(":design"))
    implementation(project(":data"))

    implementation(Dependencies.coreCtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.Voyager.navigator)
    implementation(Dependencies.Voyager.bottomSheetNavigator)
    implementation(Dependencies.Voyager.tabNavigator)
    implementation(Dependencies.Voyager.transitions)
    implementation(Dependencies.Voyager.viewModelIntegration)
    implementation(Dependencies.Voyager.hilt)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
    androidTestImplementation(Dependencies.androidTestNavigation)
    implementation(Dependencies.composeNavigation)

    implementation(platform(Dependencies.Compose.composeBom))
    androidTestImplementation(platform(Dependencies.Compose.composeBom))

    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.accompanistPager)
    implementation(Dependencies.Compose.indicators)

    debugImplementation(Dependencies.Compose.debugPreviewTooling)

    androidTestImplementation(Dependencies.Compose.androidTestJunit)
    debugImplementation(Dependencies.Compose.debugManifest)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espresso)
}

kapt {
    correctErrorTypes = true
}