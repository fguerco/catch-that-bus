package com.example.felipe.catchthatbus.infrastructure.repository

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@DisplayName("Tests for ClasspathYamlDataSource object")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class ClasspathYamlDataSourceTest {

    private lateinit var fileName: String
    private val subject get() = ClasspathYamlDataSource().load(fileName)

    @Nested
    @DisplayName("When file exists")
    inner class WithExistingFile {

        init { fileName = "testfile.txt" }

        @Test
        @DisplayName("Should return the file contents")
        internal fun loadFile() {
            assertEquals("test file contents", subject)
        }
    }

    @Nested
    @DisplayName("When file does not exist")
    inner class WhenFileDoesNotExist {

        init { fileName = "invalid.txt" }

        @Test
        @DisplayName("Should return an empty string")
        internal fun loadFile() {
            assertEquals("", subject)
        }
    }
}