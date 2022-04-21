object Apps {
    const val applicationId = "com.hlandim.movies"
    const val compileSdk = 32
    const val buildToolsVersion = "30.0.2"
    const val minSdk = 24
    const val targetSdk = 32
    const val versionCode = 1
    const val versionName = "0.0.1"
}

object Versions {
    const val hilt = "2.40.2"
    const val coroutines = "1.5.0"
    const val retrofit = "2.9.0"
    const val lifeCycle = "2.4.1"
    const val compose = "1.1.1"
    const val composeCompile = "1.2.0-alpha07"
    const val gson = "2.9.0"
    const val espresso = "3.4.0"
    const val junit = "4.13.2"
    const val support = "1.4.1"
    const val androidMaterial = "1.5.0"
    const val constraintLayout = "2.1.3"
    const val ktx = "1.7.0"
    const val mockito = "1.12.1"
    const val testCore = "1.4.0"
}

object Libs {
    const val androidxKtx = "androidx.core:core-ktx:${Versions.ktx}"
//    const val androidxCore = "androidx.core:core:core:${Versions.ktx}"
    const val androidxTestCore = "androidx.test:core:${Versions.testCore}"
    const val androidxTestRules = "androidx.test:rules:${Versions.testCore}"
    const val appcompat = "androidx.appcompat:appcompat:${Versions.support}"
    const val androidMaterial = "com.google.android.material:material:${Versions.androidMaterial}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    // jUnit
    const val junit = "junit:junit:${Versions.junit}"
    const val extJunit = "androidx.test.ext:junit:1.1.3"

    // Espresso
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    // Hilt
    const val hiltTest = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    const val hiltAndroidCompile = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltCompile = "com.google.dagger:hilt-compiler:${Versions.hilt}"

    // GSON
    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    // Retrofit
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    // OkHttp3
    const val retrofitLogging = "com.squareup.okhttp3:logging-interceptor:3.9.0" // Used by retrofit
    const val mockWebServer = "com.squareup.okhttp3:mockwebserver:4.9.1" // Used by unit tests

    // Coroutines
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinesTest =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // Lifecycle
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val lifecycleViewModelCompose =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifeCycle}"

    // Mockito
    const val mockito = "io.mockk:mockk:${Versions.mockito}"

    // Compose
    const val composeCompile = "androidx.compose.compiler:compiler:${Versions.composeCompile}"
    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling:${Versions.compose}"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val composeFoundation = "androidx.compose.foundation:foundation:${Versions.compose}"
    const val composeMaterial = "androidx.compose.material:material:${Versions.compose}"
    const val composeMaterialIcons =
        "androidx.compose.material:material-icons-core:${Versions.compose}"
    const val composeMaterialIconsExtended =
        "androidx.compose.material:material-icons-extended:${Versions.compose}"
    const val composeActivities = "androidx.activity:activity-compose:1.4.0"
    const val composeLivedata = "androidx.compose.runtime:runtime-livedata:${Versions.compose}"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4:${Versions.compose}"

    // Landscapist - A Compose component using Glide
    const val landscapist = "com.github.skydoves:landscapist-glide:1.5.0"
}

object Module {
    const val central = ":central"
    const val moviesList = ":features:movies-list"
    const val commonView = ":common:view"
    const val commonUi = ":common:ui"
    const val commonTestView = ":common:test-view"
}