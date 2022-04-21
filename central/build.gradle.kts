import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

val apiKey: String = gradleLocalProperties(rootDir).getProperty("apiKey")

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField(BuildConfigType.string, BuildConfigFields.apiKey, "\"" + apiKey + "\"")
        buildConfigField(
            BuildConfigType.string,
            BuildConfigFields.apiBaseUrl,
            "\"" + BuildConfigValues.apiBaseUrlValue + "\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField(BuildConfigType.boolean, BuildConfigFields.isLogOn, false.toString())
        }
        debug {
            buildConfigField(BuildConfigType.boolean, BuildConfigFields.isLogOn, true.toString())
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(Libs.junit_junit)
    implementation(Libs.androidx_test_ext_junit)

    // Hilt - DI
    implementation(Libs.hilt_android)
    androidTestImplementation(Libs.hilt_android_testing) // Automated test
    kapt(Libs.hilt_android_compiler)
    testImplementation(Libs.hilt_android_testing)
    kaptTest(Libs.hilt_android_testing)
    kaptAndroidTest(Libs.hilt_android_compiler)

    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.logging_interceptor)
    implementation(Libs.converter_gson)

    // Coroutines
    api(Libs.kotlinx_coroutines_core)
    api(Libs.kotlinx_coroutines_android)
    testApi(Libs.kotlinx_coroutines_test)

}