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

    implementation(Libs.junit)
    implementation(Libs.extJunit)

    // Hilt - DI
    implementation(Libs.hilt)
    androidTestImplementation(Libs.hiltTest) // Automated test
    kapt(Libs.hiltAndroidCompile)
    kapt(Libs.hiltCompile)
    testImplementation(Libs.hiltTest)
    kaptTest(Libs.hiltAndroidCompile)
    kaptAndroidTest(Libs.hiltAndroidCompile)

    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofitLogging)
    implementation(Libs.retrofitConverterGson)

    // Coroutines
    api(Libs.coroutinesCore)
    api(Libs.coroutinesAndroid)
    testApi(Libs.coroutinesTest)

}