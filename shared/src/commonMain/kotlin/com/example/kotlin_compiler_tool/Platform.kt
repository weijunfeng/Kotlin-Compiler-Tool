package com.example.kotlin_compiler_tool

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform