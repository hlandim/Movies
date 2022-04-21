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
        kotlinCompilerExtensionVersion = Versions.composeCompile
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

    implementation(Libs.androidxKtx)
    implementation(Libs.appcompat)
    implementation(Libs.androidMaterial)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.espresso)
    implementation(Libs.constraintLayout)

    implementation(Libs.composeFoundation)

    //Modules
    implementation(project(Module.central))
    implementation(project(Module.moviesList))


//    testImplementation(Libs.composeUiTestJunit)
    testImplementation(Libs.hiltTest)

    implementation("androidx.fragment:fragment-ktx:1.4.1")
    implementation(Libs.lifecycleViewModel)

    // Hilt - DI
    implementation(Libs.hilt)
    kapt(Libs.hiltCompile)
    kapt(Libs.hiltAndroidCompile)

}