package com.methodpref.plugin

import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilerPluginSupportPlugin
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

/**
 * 统计方法耗时的 IR 插件
 */
class MethodPerfIRPlugin : KotlinCompilerPluginSupportPlugin {

    override fun apply(target: Project) {
        super.apply(target)
    }

    override fun applyToCompilation(kotlinCompilation: KotlinCompilation<*>): Provider<List<SubpluginOption>> {
        val project = kotlinCompilation.target.project
        return project.provider {
            listOf()
        }
    }

    override fun getCompilerPluginId(): String {
        return "com.kotlin.method.performance"
    }

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        "com.kotlin.method.performance",
        "methodpref-compiler-embeddable",
        "1.2.0"
    )

    override fun isApplicable(kotlinCompilation: KotlinCompilation<*>): Boolean = true
}