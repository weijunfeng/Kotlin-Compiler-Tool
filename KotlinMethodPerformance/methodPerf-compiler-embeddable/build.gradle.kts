plugins {
    java
    id("com.bennyhuo.kotlin.plugin.embeddable")
}

dependencies {
    embedded(project(":methodPerf-compiler"))
}