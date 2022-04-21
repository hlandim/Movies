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
        kotlinCompilerExtensionVersion = Apps.versions.getProperty("version.androidx.compose.compiler")
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
    implementation(project(Module.central))
    implementation(project(Module.commonView))
    implementation(project(Module.commonUi))
    implementation(project(Module.commonData))
    androidTestImplementation(project(Module.commonTestView))

    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.com_google_android_material_material)
    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)
    androidTestImplementation(Libs.core_ktx)
    androidTestImplementation(Libs.espresso_core)

    // GSON
    testImplementation(Libs.gson)

    // Retrofit
    testImplementation(Libs.retrofit)
    testImplementation(Libs.logging_interceptor)
    testImplementation(Libs.converter_gson)
    androidTestImplementation(Libs.logging_interceptor)
    androidTestImplementation(Libs.converter_gson)

    // Coroutines
    testImplementation(Libs.kotlinx_coroutines_test)

    //Mockito
    testImplementation(Libs.mockk)

    implementation(Libs.fragment_ktx)

    //MockWebserver
    testImplementation(Libs.mockwebserver)
    // Needed for unit testing API
    testImplementation(Libs.core_testing)

    // ViewModel
    implementation(Libs.lifecycle_viewmodel_ktx)


    // Hilt - DI
    implementation(Libs.hilt_android)
    androidTestImplementation(Libs.hilt_android_testing) // Automated test
    kapt(Libs.hilt_android_compiler)
    testImplementation(Libs.hilt_android_testing)
    kaptTest(Libs.hilt_android_testing)
    kaptAndroidTest(Libs.hilt_android_compiler)

    // Android JetpackCompose
    implementation(Libs.ui)
    // Tooling support (Previews, etc.)
    debugImplementation(Libs.ui_tooling_preview)
    implementation(Libs.ui_tooling_preview)
    // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
    implementation(Libs.foundation)
    // Material Design
    implementation(Libs.androidx_compose_material_material)
    // Material design icons
    implementation(Libs.material_icons_core)
    implementation(Libs.material_icons_extended)
    // Integration with activities
    implementation(Libs.activity_compose)
    // Integration with ViewModels
    implementation(Libs.lifecycle_viewmodel_compose)
    // Integration with observables
    implementation(Libs.runtime_livedata)

    implementation(Libs.androidx_compose_compiler_compiler)
}