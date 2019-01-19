package com.example.felipe.catchthatbus.departures

import java.time.DayOfWeek

val weekdays = listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)
val onlySaturday = listOf(DayOfWeek.SATURDAY)

val scheduleCentroViaZonaSul =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL,
                                                           weekdays,
                                                           listOf(540, 625, 705, 715, 820, 1000, 1200, 1300, 1700, 1850, 2000))

val scheduleCentroViaLinhaAmarela =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_L_AMARELA,
                                                           weekdays,
                                                           listOf(615, 910, 1610, 1730))

val scheduleCentroViaTijuca =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_TIJUCA,
                                                           weekdays,
                                                           listOf(730, 1600))

val scheduleCentroZonaSulEspecial =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL_L_AMARELA_ESPECIAL,
                                                           weekdays,
                                                           listOf(650))

val scheduleBarraBaliViaZonaSul =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_ZONA_SUL,
                                                           weekdays,
                                                           listOf(1000, 1210, 1410, 1530, 1730, 1900, 2030, 2215))

val scheduleBarraBaliViaLinhaAmarela =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_L_AMARELA,
                                                           weekdays,
                                                           listOf(640, 720, 1715, 1750, 1820, 1920))

val scheduleBarraBaliViaTijuca =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_TIJUCA,
                                                           weekdays,
                                                           listOf(940, 1740))

val scheduleBarraBaliViaJdBotanico =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_JD_BOTANICO,
                                                           weekdays,
                                                           listOf(750))

val scheduleCircularBarraWeekdays =
    BusSchedule(BusRoute.CIRCULAR_BARRA,
                                                           weekdays,
                                                           listOf(650, 810, 920, 1050, 1240, 1400, 1600, 1800))
val scheduleCircularBarraSaturday =
    BusSchedule(BusRoute.CIRCULAR_BARRA,
                                                           onlySaturday,
                                                           listOf(930, 1400, 1800))

val scheduleCircularRecreioWeekdays =
    BusSchedule(BusRoute.CIRCULAR_RECREIO,
                                                           weekdays,
                                                           listOf(630, 1245))

val scheduleCircularRecreioSaturday =
    BusSchedule(BusRoute.CIRCULAR_RECREIO,
                                                           onlySaturday,
                                                           listOf(1130, 1600))

val allSchedules = listOf(scheduleCentroViaZonaSul,
                          scheduleCentroViaLinhaAmarela,
                          scheduleCentroViaTijuca,
                          scheduleCentroZonaSulEspecial,
                          scheduleBarraBaliViaZonaSul,
                          scheduleBarraBaliViaLinhaAmarela,
                          scheduleBarraBaliViaTijuca,
                          scheduleBarraBaliViaJdBotanico,
                          scheduleCircularBarraWeekdays,
                          scheduleCircularBarraSaturday,
                          scheduleCircularRecreioWeekdays,
                          scheduleCircularRecreioSaturday).asSequence()