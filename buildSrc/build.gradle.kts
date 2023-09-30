plugins {
    `kotlin-dsl`
//    id("org.gradle.kotlin.kotlin-dsl")
//    kotlin("jvm")
    id("java-gradle-plugin")
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation(gradleApi())
    implementation(localGroovy())
//    implementation(kotlin("gradle-plugin"))
    implementation(kotlin("compiler-embeddable"))
    // kotlin-dsl 的依赖项
    implementation(gradleKotlinDsl())
    implementation(libs.plugin.kotlin)
    implementation(libs.plugin.gradle)
    implementation(libs.plugin.shadow)

    testImplementation(kotlin("test"))
}

// 在 buildSrc配置 gradle plugin 无需发布即可在项目中使用
gradlePlugin {
    plugins {
        create("MethodPerfPlugin") {
            id = "com.zzt.demo.MethodPerfIRPlugin"
            implementationClass = "com.zzt.demo.MethodPerfIRPlugin"
        }
        create("EmbeddablePlugin") {
            id = "com.bennyhuo.kotlin.plugin.embeddable"
            displayName = "Gradle plugin for embeddable Kotlin compiler plugin"
            description = "Gradle plugin for embeddable Kotlin compiler plugin"
            implementationClass = "com.bennyhuo.kotlin.plugin.embeddable.EmbeddablePlugin"
        }

        create("EmbeddableTestPlugin") {
            id = "com.bennyhuo.kotlin.plugin.embeddable.test"
            displayName = "Gradle plugin for testing embeddable Kotlin compiler plugin"
            description = "Gradle plugin for testing embeddable Kotlin compiler plugin"
            implementationClass = "com.bennyhuo.kotlin.plugin.embeddable.EmbeddableTestPlugin"
        }
    }
}

tasks.configureEach {
    if (this.name.contains("Test") || this.name.contains("test")) {
        this.enabled = false
    }
}