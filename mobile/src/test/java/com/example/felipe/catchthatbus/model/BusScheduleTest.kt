package com.example.felipe.catchthatbus.model

import com.example.felipe.catchthatbus.infrastructure.Services
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import java.util.Calendar

@Suppress("ClassName")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class BusScheduleTest {

    private val data = Services.scheduleRepository.fetchData()

    @Nested
    inner class `Given route is Centro x Barra Bali via L Amarela` {
        private val route = BusRoute.CENTRO_BARRA_BALI_VIA_L_AMARELA

        @Nested
        inner class `and the time is 17-1-2018 1430` {
            private val date = Calendar.getInstance().apply {
                set(2018, Calendar.JANUARY, 17, 14, 30)
            }

            private val subject = data.nextDepartures(route, date).toList()

            @Test
            internal fun `nextDepartures() should list 4 departures`() {
                assertEquals(4, subject.size)
            }

            @Test
            internal fun `nextDepartures() should have departures at 1715, 1750, 1820 and 1920`() {
                assertEquals(listOf(1715, 1750, 1820, 1920),
                             subject.map { it.time })
            }
        }

        @Nested
        inner class `and the time is 14-8-2018 1800` {
            private val instant = Calendar.getInstance().apply {
                set(2018, Calendar.AUGUST, 14, 18, 0)
            }

            private val subject = data.nextDepartures(route, instant).toList()

            @Test
            internal fun `nextDepartures() should list 2 departures`() {
                assertEquals(2, subject.size)
            }

            @Test
            internal fun `nextDepartures() should have departures at 1715, 1750, 1820 and 1920`() {
                assertEquals(listOf(1820, 1920),
                             subject.map { it.time })
            }
        }
    }

    @Nested
    inner class `Given route is Barra Bali x Centro via Zona Sul` {

        private val route = BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL

        @Nested
        inner class `and Day is monday` {

            private val day = Calendar.MONDAY

            @Nested
            inner class `and time is 1430` {

                private val time = 1430

                private val subject = data.nextDepartures(route, day, time).toList()

                @Test
                internal fun `nextDepartures() should list 3 schedules`() {
                    assertEquals(3, subject.size)
                }

                @Test
                internal fun `nextDepartures() should have 1700, 1850 and 2000 as time`() {
                    assertEquals(listOf(1700, 1850, 2000),
                                 subject.map { it.time })
                }
            }
        }
    }

    @Nested
    inner class `Given day of week is saturday` {
        private val day = Calendar.SATURDAY

        @Nested
        inner class `and time is 1200` {
            private val time = 1200

            private val subject = data.allDepartures(day, time).toList()

            @Test
            internal fun `departuresFromAllAvailableRoutes() should return 3 items`() {
                assertEquals(3, subject.size)
            }

            @Test
            internal fun `departuresFromAllAvailableRoutes() should have departures of circular barra and circular recreio`() {
                assertEquals(listOf(BusRoute.CIRCULAR_BARRA, BusRoute.CIRCULAR_RECREIO),
                             subject.map { it.route }.distinct() )
            }
        }
    }
}