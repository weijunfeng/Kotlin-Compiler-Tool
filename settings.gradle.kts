pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Kotlin-Compiler-Tool"
include(":androidApp")
include(":shared")
include("annotations")
project(":annotations").projectDir = file("kmp-shadow/KotlinDeepCopy-annotation")
include("runtime")
project(":runtime").projectDir = file("kmp-shadow/KotlinDeepCopy-runtime")
//include(":KtIRTransformSample")
include("kcp-impl:compiler-kcp")
project(":kcp-impl:compiler-kcp").projectDir = file("KotlinDeepCopy/kcp-impl/compiler-kcp")
include("kcp-impl:compiler-kcp-embeddable")
project(":kcp-impl:compiler-kcp-embeddable").projectDir =
    file("KotlinDeepCopy/kcp-impl/compiler-kcp-embeddable")

include("trimindent-compiler")
project(":trimindent-compiler").projectDir = file("Kotlin-Trim-Indent/trimindent-compiler")
include("trimindent-compiler-embeddable")
project(":trimindent-compiler-embeddable").projectDir =
    file("Kotlin-Trim-Indent/trimindent-compiler-embeddable")

include(":KtIRTransformSample")

include("methodPerf-compiler")
project(":methodPerf-compiler").projectDir = file("KotlinMethodPerformance/methodPerf-compiler")
include("methodPerf-compiler-embeddable")
project(":methodPerf-compiler-embeddable").projectDir =
    file("KotlinMethodPerformance/methodPerf-compiler-embeddable")
include("methodPref-annotations")
project(":methodPref-annotations").projectDir =
    file("KotlinMethodPerformance/methodPref-annotations")

