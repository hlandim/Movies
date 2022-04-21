plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk

        testInstrumentationRunner = "com.hlandim.movies.common.testview.CustomTestRunner"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeCompile
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
    implementation(project(Module.central))
    implementation(project(Module.commonView))
    implementation(project(Module.commonUi))
    androidTestImplementation(project(Module.commonTestView))

    implementation(Libs.androidxKtx)
    implementation(Libs.appcompat)
    implementation(Libs.androidMaterial)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.androidxKtx)
    androidTestImplementation(Libs.espresso)

    // GSON
    testImplementation(Libs.gson)

    // Retrofit
    testImplementation(Libs.retrofit)
    testImplementation(Libs.retrofitLogging)
    testImplementation(Libs.retrofitConverterGson)
    androidTestImplementation(Libs.retrofitLogging)
    androidTestImplementation(Libs.retrofitConverterGson)

    // Coroutines
    testImplementation(Libs.coroutinesTest)

    //Mockito
    testImplementation(Libs.mockito)

    implementation("androidx.fragment:fragment-ktx:1.4.1")

    //MockWebserver
    testImplementation(Libs.mockWebServer)
    // Needed for unit testing API
    testImplementation("androidx.arch.core:core-testing:2.1.0")

    // ViewModel
    implementation(Libs.lifecycleViewModel)


    // Hilt - DI
    implementation(Libs.hilt)
    androidTestImplementation(Libs.hiltTest) // Automated test hilt-android-testing
    testImplementation(Libs.hiltTest)
    kapt(Libs.hiltAndroidCompile)
    kapt(Libs.hiltCompile)
    kaptTest(Libs.hiltAndroidCompile)
    kaptAndroidTest(Libs.hiltCompile)
    kaptAndroidTest(Libs.hiltTest)
    kaptAndroidTest(Libs.hiltAndroidCompile)

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
    androidTestImplementation(Libs.composeUiTestJunit)
}