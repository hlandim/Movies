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

        testInstrumentationRunner = "com.hlandim.movies.util.CustomTestRunner"
    }

    buildFeatures {
        // Enables Jetpack Compose for this module
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion =  Versions.composeCompile
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
}

dependencies {

    implementation(Libs.ktxCore)
    implementation(Libs.appcompat)
    implementation(Libs.androidMaterial)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.espresso)
    implementation(Libs.constraintLayout)


    // Automated test
    androidTestImplementation(Libs.espresso)

    // Hilt - DI
    implementation(Libs.hilt)
    androidTestImplementation(Libs.hiltTest) // Automated test
    kapt(Libs.hiltCompile)
    testImplementation(Libs.hiltTest)
    kaptTest(Libs.hiltCompile)
    kaptAndroidTest(Libs.hiltCompile)

    // GSON - Used only to parse a JSON for test purpose
    testImplementation(Libs.gson)

    // Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    testImplementation(Libs.coroutinesTest)

    // ViewModel
    implementation(Libs.lifecycleViewModel)

    //Mockito
    testImplementation(Libs.mockito)

    // Android JetpackCompose
    implementation(Libs.composeUi)
    // Tooling support (Previews, etc.)
    debugImplementation(Libs.composeUiTooling)
    implementation(Libs.composeUiToolingPreview)
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(Libs.composeFoundation)
    // Material Design
    implementation(Libs.composeMaterial)
    // Material design icons
    implementation(Libs.composeMaterialIcons)
    implementation(Libs.composeMaterialIconsExtended)
    // Integration with activities
    implementation(Libs.composeActivities)
    // Integration with ViewModels
    implementation(Libs.lifecycleViewModelCompose)
    // Integration with observables
    implementation(Libs.composeLivedata)

    implementation(Libs.composeCompile)

    implementation(Libs.landscapist)

    implementation("androidx.fragment:fragment-ktx:1.4.1")

    // UI Tests
    androidTestImplementation(Libs.composeUiTestJunit)

    implementation(project(Module.central))


}