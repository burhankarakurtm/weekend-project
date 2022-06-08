plugins {
    id("commons.android-library")
}
dependencies {
    api(project(Modules.COMMON))
    implementation(Dependencies.OK_HTTP3_LOGGING_INTERCEPTOR)
    implementation(Dependencies.OK_HTTP3)
    implementation(Dependencies.MOSHI_KOTLIN)
    implementation(Dependencies.RETROFIT_CONVERTER_GSON)

}
