import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    java
    kotlin("kapt")
    id("com.github.gmazzo.buildconfig")
    id("com.bennyhuo.kotlin.plugin.embeddable.test")
}
group = "com.kotlin.method.performance.compiler"

dependencies {
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib")
    compileOnly("org.jetbrains.kotlin:kotlin-compiler")

    implementation(project(":methodPref-annotations"))

    kapt("com.google.auto.service:auto-service:1.0.1")
    compileOnly("com.google.auto.service:auto-service-annotations:1.0.1")

    testImplementation(kotlin("test-junit"))
    testImplementation("org.jetbrains.kotlin:kotlin-compiler-embeddable")
    testImplementation("com.bennyhuo.kotlin:kotlin-compile-testing-extensions:1.8.20-1.2.0")
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.freeCompilerArgs += listOf(
    "-opt-in=kotlin.RequiresOptIn",
    "-opt-in=org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi"
)

buildConfig {
    packageName("$group.trimindent")
    buildConfigField("String", "KOTLIN_PLUGIN_ID", "\"${project.property("KOTLIN_PLUGIN_ID")}\"")
}
