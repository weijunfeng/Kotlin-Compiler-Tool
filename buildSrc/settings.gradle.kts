dependencyResolutionManagement {
    // 复用版本配置
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}