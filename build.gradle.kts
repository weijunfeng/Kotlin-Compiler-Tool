buildscript {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
    // 这里不用 plugins配置，会与 buildSrc的配置冲突
    //https://github.com/gradle/gradle/issues/20084
    dependencies {
        classpath(libs.plugin.gradle)
        classpath(libs.plugin.kotlin)
        classpath(libs.plugin.buildconfig)
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

allprojects {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            // 远程依赖替换为本地项目
            substitute(module("com.bennyhuo.kotlin:deepcopy-compiler-kcp-embeddable"))
                .using(
                    project(":kcp-impl:compiler-kcp-embeddable")
                )
            substitute(module("com.bennyhuo.kotlin:trimindent-compiler-embeddable"))
                .using(
                    project(":trimindent-compiler-embeddable")
                )
            substitute(module("com.kotlin.method.performance:methodpref-compiler-embeddable"))
                .using(
                    project(":methodPerf-compiler-embeddable")
                )
        }
    }
}

project(":kcp-impl:compiler-kcp").group = "com.bennyhuo.kotlin"
project(":trimindent-compiler").group = "com.bennyhuo.kotlin"
