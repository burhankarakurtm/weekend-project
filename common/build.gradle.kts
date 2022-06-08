plugins {
    id("commons.android-library")
}

dependencies {
    api(Dependencies.APPCOMPAT)
    api(Dependencies.CORE_KTX)
    implementation(Dependencies.GLIDE)
    implementation(Dependencies.HILT_ANDROID)
    implementation(Dependencies.LOTTIE)
    implementation(Dependencies.RETROFIT)
    kapt(Dependencies.HILT_ANDROID_COMPILER)
    kapt(Dependencies.GLIDE_COMPILER)
}
