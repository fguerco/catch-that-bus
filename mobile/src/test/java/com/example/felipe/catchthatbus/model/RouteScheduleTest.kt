package com.example.felipe.catchthatbus.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@DisplayName("Tests for RouteSchedule object")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class RouteScheduleTest {

    @Nested
    @DisplayName("Constructed with map")
    inner class WithMapConstructor {

        @Test
        @DisplayName("When a valid map is given")
        internal fun withValidMap() {
            val map = mapOf(
                ROUTE_KEY to "CENTRO_BARRA_BALI_VIA_ZONA_SUL",
                DAYS_KEY to listOf(1, 2, 3),
                DEPARTURES_KEY to listOf(4, 5, 6)
            )

            val subject = RouteSchedule(map)

            assertEquals(BusRoute.CENTRO_BARRA_BALI_VIA_ZONA_SUL, subject.route)
            assertEquals(listOf(1, 2, 3), subject.days)
            assertEquals(listOf(4, 5, 6), subject.departures)
        }
    }
}