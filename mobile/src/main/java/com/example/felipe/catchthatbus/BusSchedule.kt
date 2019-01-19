package com.example.felipe.catchthatbus

import java.time.DayOfWeek

enum class BusRoute {
    BARRA_BALI_CENTRO_VIA_ZONA_SUL,
    BARRA_BALI_CENTRO_VIA_L_AMARELA,
    BARRA_BALI_CENTRO_VIA_TIJUCA,
    BARRA_BALI_CENTRO_VIA_ZONA_SUL_L_AMARELA_ESPECIAL,

    CENTRO_BARRA_BALI_VIA_ZONA_SUL,
    CENTRO_BARRA_BALI_VIA_L_AMARELA,
    CENTRO_BARRA_BALI_VIA_TIJUCA,
    CENTRO_BARRA_BALI_VIA_JD_BOTANICO,

    CIRCULAR_BARRA,
    CIRCULAR_RECREIO
}

// nao circula nos domingos
// rotas diferentes por dia da semana
data class BusSchedule(val route: BusRoute, val days: List<DayOfWeek>, val departures: List<Int>)

val weekDays = listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY)

val scheduleCentroViaZonaSul =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL,
                weekDays,
                listOf(540, 625, 705, 715, 820, 1000, 1200, 1300, 1700, 2000))

val scheduleCentroViaLinhaAmarela =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_L_AMARELA,
                weekDays,
                listOf(615, 910, 1610, 1730))

val scheduleCentroViaTijuca =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_TIJUCA,
                weekDays,
                listOf(730, 1600))

val scheduleCentroZonaSulEspecial =
    BusSchedule(BusRoute.BARRA_BALI_CENTRO_VIA_ZONA_SUL_L_AMARELA_ESPECIAL,
                weekDays,
                listOf(650))

val scheduleBarraBaliViaZonaSul =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_ZONA_SUL,
                weekDays,
                listOf(1000, 1210, 1410, 1530, 1730, 1900, 2030, 2215))

val scheduleBarraBaliViaLinhaAmarela =
    BusSchedule(BusRoute.CENTRO_BARRA_BALI_VIA_L_AMARELA,
                weekDays,
                listOf(640, 720, 1715, 1750, 1820, 1920))

val scheduleBarraBaliViaTijuca =
    BusSchedule()