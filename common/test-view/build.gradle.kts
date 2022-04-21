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
        enableTransformForLocalTests = true
    }
}

dependencies {

    implementation(Libs.appcompat)
    testImplementation(Libs.junit)

    implementation(Libs.hiltTest)
    api(Libs.composeUiTestJunit)

    api(Libs.androidxTestCore)
    api(Libs.androidxTestRules)

    // Hilt - DI
    implementation(Libs.hilt)
    testImplementation(Libs.hiltTest)
    kapt(Libs.hiltAndroidCompile)
    kapt(Libs.hiltCompile)

}