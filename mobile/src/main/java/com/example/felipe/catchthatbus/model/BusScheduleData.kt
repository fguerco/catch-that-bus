package com.example.felipe.catchthatbus.model

import java.util.Calendar


val weekdays = listOf(Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY, Calendar.THURSDAY, Calendar.FRIDAY)
val onlySaturday = listOf(Calendar.SATURDAY)

val scheduleCentroViaZonaSul =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL,
                weekdays,
                listOf(540, 625, 650, 710, 740, 820, 1000, 1200, 1300, 1700, 1850, 2000))

val scheduleCentroViaLinhaAmarela =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_L_AMARELA,
                weekdays,
                listOf(615, 910, 1610, 1730))

val scheduleCentroViaTijuca =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_TIJUCA,
                weekdays,
                listOf(730, 1600))

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
                listOf(700, 805, 920, 1050, 1240, 1400, 1600, 1800))

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
                          scheduleBarraBaliViaZonaSul,
                          scheduleBarraBaliViaLinhaAmarela,
                          scheduleBarraBaliViaTijuca,
                          scheduleBarraBaliViaJdBotanico,
                          scheduleCircularBarraWeekdays,
                          scheduleCircularBarraSaturday,
                          scheduleCircularRecreioWeekdays,
                          scheduleCircularRecreioSaturday).asSequence()