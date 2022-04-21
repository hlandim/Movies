plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Apps.compileSdk

    defaultConfig {
        minSdk = Apps.minSdk
        targetSdk = Apps.targetSdk
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
}

dependencies {

    implementation(Libs.core_ktx)
    implementation(Libs.appcompat)
    implementation(Libs.com_google_android_material_material)
    testImplementation(Libs.junit_junit)
    androidTestImplementation(Libs.androidx_test_ext_junit)

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