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
    namespace = "yegor.cheprasov.fluentflow"
    compileSdk = 33

    defaultConfig {
        applicationId = "yegor.cheprasov.fluentflow"
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
    implementation(project(":topics"))
    implementation(project(":words"))
    implementation(project(":grammar"))

    implementation(Dependencies.coreCtx)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.material)
    implementation(Dependencies.constraintLayout)

    implementation(Dependencies.hiltAndroid)
    kapt(Dependencies.hiltCompiler)

    implementation(Dependencies.navigationFragment)
    implementation(Dependencies.navigationUi)
    androidTestImplementation(Dependencies.androidTestNavigation)
    implementation(Dependencies.composeNavigation)

    implementation(platform(Dependencies.firebaseBom))
    implementation(Dependencies.firebaseAnalytics)

    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitAndroid)
    androidTestImplementation(Dependencies.espresso)
}

kapt {
    correctErrorTypes = true
}