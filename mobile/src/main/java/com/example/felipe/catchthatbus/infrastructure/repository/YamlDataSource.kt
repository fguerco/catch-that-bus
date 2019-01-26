package com.example.felipe.catchthatbus.infrastructure.repository

interface YamlDataSource {
    fun load(resourceName: String): String
}

class ClasspathYamlDataSource : YamlDataSource {
    override fun load(resourceName: String) = javaClass.classLoader
        ?.getResourceAsStream(resourceName)
        ?.bufferedReader()
        ?.use { it.readText() } ?: ""
}