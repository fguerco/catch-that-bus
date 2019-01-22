package com.example.felipe.catchthatbus.model

import java.util.Calendar

data class RouteSchedule(val route: BusRoute, val days: List<Int>, val departures: List<Int>)


fun Sequence<RouteSchedule>.routesOf(date: Calendar) = filter { it.days.contains(date.dayOfWeek) }

private val Calendar.dayOfWeek get() = get(Calendar.DAY_OF_WEEK)