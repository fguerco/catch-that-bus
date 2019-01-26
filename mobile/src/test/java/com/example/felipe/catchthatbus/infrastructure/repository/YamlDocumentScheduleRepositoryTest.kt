package com.example.felipe.catchthatbus.infrastructure.repository

import com.example.felipe.catchthatbus.model.BusRoute
import com.example.felipe.catchthatbus.model.RouteSchedule
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@DisplayName("Tests for YamlDocumentScheduleRepository object")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class YamlDocumentScheduleRepositoryTest {

    private val mockDataSource = mockk<YamlDataSource>()
    private val subject get() = YamlDocumentScheduleRepository(mockDataSource).allSchedules().toList()

    @Nested
    @DisplayName("With a valid yaml data")
    inner class WithValidYaml {

        init {
            val yamlData = """
                - route: CIRCULAR_BARRA
                  days: [1, 2]
                  departures: [3, 4]
            """.trimIndent()

            every { mockDataSource.load(ROUTES_FILE) } returns yamlData
        }

        @Test
        @DisplayName("Should return a list with one route schedule")
        internal fun loadYaml() {
            assertEquals(1, subject.size)
        }

        @Test
        @DisplayName("Should have a RouteSchedule instance with route CIRCULAR_BARRA, days [1, 2] and departures [3, 4]")
        internal fun checkData() {
            val expectedData = RouteSchedule(BusRoute.CIRCULAR_BARRA, listOf(1, 2), listOf(3, 4))

            assertEquals(expectedData, subject.first())
        }
    }

    @Nested
    @DisplayName("With an empty yaml document")
    inner class WithAnEmptyDocument {

        init {
            every { mockDataSource.load(ROUTES_FILE) } returns ""
        }

        @Test
        @DisplayName("Should return an empty list")
        internal fun loadYaml() {
            assertEquals(0, subject.size)
        }
    }
}