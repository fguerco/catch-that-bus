package com.example.felipe.catchthatbus.model

import com.example.felipe.catchthatbus.model.data.allSchedules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.Calendar
import java.util.GregorianCalendar

@DisplayName("Tests for routes of the day")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class RouteScheduleRoutesTest {

    private val data = allSchedules

    @Nested
    @DisplayName("Given the date is Wed 17/01/2018")
    inner class GivenDateIsWednesday {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 17)
        private val subject = data.routesOf(date).toList()

        @Test
        @DisplayName("Should have nine routes")
        internal fun nineRoutesExpected() {
            assertEquals(9, subject.size)
        }
    }

    @Nested
    @DisplayName("Given the date is Sat 20/01/2018")
    inner class GivenDateIsSaturday {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 20, 10, 0)
        private val subject = data.routesOf(date).toList()

        @Test
        @DisplayName("Should have two routes")
        internal fun twoRoutesExpected() {
            assertEquals(2, subject.size)
        }
    }

    @Nested
    @DisplayName("Given the date is Sun 21/01/2018")
    inner class GivenDateIsSunday {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 21)
        private val subject = data.routesOf(date).toList()

        @Test
        @DisplayName("Should have no routes")
        internal fun noRoutesExpected() {
            assertEquals(0, subject.size)
        }
    }
}
