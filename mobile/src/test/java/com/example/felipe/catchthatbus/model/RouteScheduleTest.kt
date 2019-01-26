package com.example.felipe.catchthatbus.model

import com.example.felipe.catchthatbus.model.data.allSchedules
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.Calendar
import java.util.GregorianCalendar

@Suppress("ClassName")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class RouteScheduleTest {

    private val data = allSchedules

    @Nested
    inner class `Given the date is Wed 17-1-2018` {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 17)
        private val subject = data.routesOf(date).toList()

        @Test
        internal fun `Should have nine routes`() {
            assertEquals(9, subject.size)
        }
    }

    @Nested
    inner class `Given the date is Sat 20-1-2018` {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 20, 10, 0)
        private val subject = data.routesOf(date).toList()

        @Test
        internal fun `Should have two routes`() {
            assertEquals(2, subject.size)
        }
    }

    @Nested
    inner class `Given the date is Sun 21-1-2018` {

        private val date = GregorianCalendar(2018, Calendar.JANUARY, 21)
        private val subject = data.routesOf(date).toList()

        @Test
        internal fun `Should have no routes`() {
            assertEquals(0, subject.size)
        }
    }
}
