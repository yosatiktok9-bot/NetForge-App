plugins {
    alias(libs.plugins.android.application) version libs.versions.agp apply false
    alias(libs.plugins.kotlin.android) version libs.versions.kotlin apply false
    alias(libs.plugins.kotlin.ksp) version libs.versions.ksp apply false
}

task("clean", Delete::class) {
    delete(rootProject.buildDir)
}
