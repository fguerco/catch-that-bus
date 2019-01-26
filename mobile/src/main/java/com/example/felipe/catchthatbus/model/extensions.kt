package com.example.felipe.catchthatbus.model

import java.util.Calendar

private val Calendar.dayOfWeek get() = get(Calendar.DAY_OF_WEEK)

fun Sequence<RouteSchedule>.routesOf(date: Calendar) = filter { it.days.contains(date.dayOfWeek) }

fun Any?.asBusRoute() = BusRoute.valueOf(toString())