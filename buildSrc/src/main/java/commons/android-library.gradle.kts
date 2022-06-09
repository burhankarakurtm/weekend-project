package commons

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    api(Dependencies.APPCOMPAT)
    api(Dependencies.CORE_KTX)
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.LOTTIE)
    implementation(Dependencies.RETROFIT)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    annotationProcessor(Dependencies.GLIDE_COMPILER)
}
