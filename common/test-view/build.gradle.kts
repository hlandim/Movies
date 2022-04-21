plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
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

    hilt {
        enableAggregatingTask = true
    }
}

dependencies {

    implementation(Libs.junit_junit)
    implementation(Libs.androidx_test_ext_junit)

    implementation(Libs.hilt_android_testing)
    api(Libs.ui_test_junit4)

    // Hilt - DI
    implementation(Libs.hilt_android)
    androidTestImplementation(Libs.hilt_android_testing) // Automated test
    kapt(Libs.hilt_android_compiler)
    testImplementation(Libs.hilt_android_testing)
    kaptTest(Libs.hilt_android_testing)
    kaptAndroidTest(Libs.hilt_android_compiler)
}