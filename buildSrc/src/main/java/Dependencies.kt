import org.gradle.api.JavaVersion

/**
 * Versions
 */
object Versions {
    val versionCode = 1
    val versionName = "1.0"
    val androidMinSdkVersion = 29
    val androidTargetSdkVersion = 32
    val androidCompileSdkVersion = 32
    val javaCompatibility = JavaVersion.VERSION_1_8
    val kotlinJvmTarget = "1.8"
    val android_gradle = "7.0.4"
    val kotlin = "1.6.10"
    val coroutines = "1.5.2"
    val coreKtx = "1.7.0"
    val appCompat = "1.4.1"
    val fragment = "1.4.0"
    val constraintLayout = "2.1.2"
    val javaxAnnotation = "1.0"
    val javaxInject = "1"
    val room = "2.4.0"
    val lifecycle = "2.4.0"
    val timber = "4.7.1"
    val junit = "4.13.2"
    val mockitoKotlin = "3.2.0"
    val espresso = "3.4.0"
    val robolectric = "4.7.2"
    val androidXTest = "1.4.0"
    val androidXJUnit = "1.1.3"
    val androidXArchTest = "2.1.0"
    val hilt = "2.40.5"
    val hilt_viewModel = "1.0.0-alpha03"
    val hilt_compiler = "1.0.0"
    val legacySupport = "1.0.0"
    val hilt_compiler_kapt = "2.38.1"
    val lifecycle_extn = "2.2.0"
    val gson = "2.8.7"
    val material = "1.5.0"
    val retrofit = "2.9.0"
    val okhttp = "5.0.0-alpha.2"
    val picasso = "2.5.0"
}

/**
 * Plugins
 **/
object Plugins {
    val android_gradle  = "com.android.tools.build:gradle:${Versions.android_gradle}"
    val kotlin          = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val hilt            = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}"
}

/**
 * Application libraries
 **/
object Lib {
    val kotlin              = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
    val coroutines          = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid   = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val javaxAnnotation     = "javax.annotation:jsr250-api:${Versions.javaxAnnotation}"
    val javaxInject         = "javax.inject:javax.inject:${Versions.javaxInject}"
    val android_core        = "androidx.core:core-ktx:${Versions.coreKtx}"
    val android_appCompat   = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val android_fragment    = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    val viewmodel           = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleRuntime_ktx    = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"
    val lifecycleRuntime    = "androidx.lifecycle:lifecycle-runtime:${Versions.lifecycle}"
    val constraintLayout    = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val room                = "androidx.room:room-ktx:${Versions.room}"
    val roomCompiler        = "androidx.room:room-compiler:${Versions.room}"
    val room_runtime        = "androidx.room:room-runtime:${Versions.room}"
    val hilt                = "com.google.dagger:hilt-android:${Versions.hilt}"
    val hilt_compiler       = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    val hilt_viewmodel      = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt_viewModel}"
    val hilt_compiler_kapt  = "androidx.hilt:hilt-compiler:${Versions.hilt_compiler}"
    val hilt_compiler_kapt_ = "com.google.dagger:hilt-compiler:${Versions.hilt_compiler_kapt}"
    val material            = "com.google.android.material:material:${Versions.material}"
    val legacy_support      = "androidx.legacy:legacy-support-v4:${Versions.legacySupport}"
    val lifecycle_extn      = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_extn}"
    val lifecycle_livedata  = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val gson                = "com.google.code.gson:gson:${Versions.gson}"
    val timber              = "com.jakewharton.timber:timber:${Versions.timber}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofit_gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    val okhttp_log = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    val picasso = "com.squareup.picasso:picasso:${Versions.picasso}"
}

/**
 * Testing libraries
 **/
object TestLib {
    val coroutines          = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    val junit               = "junit:junit:${Versions.junit}"
    val kotlinJUnit         = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    val mockito             = "org.mockito.kotlin:mockito-kotlin:${Versions.mockitoKotlin}"
    val robolectric         = "org.robolectric:robolectric:${Versions.robolectric}"
    val espressoCore        = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val androidCore         = "androidx.test:core-ktx:${Versions.androidXTest}"
    val androidJUnit        = "androidx.test.ext:junit-ktx:${Versions.androidXJUnit}"
    val androidArchCore     = "androidx.arch.core:core-testing:${Versions.androidXArchTest}"
    val androidFragment     = "androidx.fragment:fragment-testing:${Versions.fragment}"
    val hilt_android_test   = "com.google.dagger:hilt-android-testing:${Versions.hilt}"
    val truth               = "com.google.truth:truth:1.0.1"
}
