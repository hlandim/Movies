plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        applicationId = Apps.applicationId
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Apps.versions.getProperty("version.androidx.compose.compiler")
    }

    buildTypes {
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

    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.com_google_android_material_material)
    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    implementation(Libs.constraintlayout)

    implementation(Libs.foundation)

    //Modules
    implementation(project(Module.central))
    implementation(project(Module.featMoviesList))


//    testImplementation(Libs.composeUiTestJunit)
    testImplementation(Libs.hilt_android_testing)

    implementation(AndroidX.fragment.ktx)
    implementation(Libs.lifecycle_viewmodel_ktx)

    // Hilt - DI
    implementation(Libs.hilt_android)
    kapt(Libs.hilt_android_compiler)

}