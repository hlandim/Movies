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
}

dependencies {

    implementation(Libs.androidxKtx)
    implementation(Libs.appcompat)
    implementation(Libs.androidMaterial)
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)

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

}