package com.example.felipe.catchthatbus.departures

import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar

fun BusRoute.nextDepartures(day: DayOfWeek, time: Int): List<BusDeparture> {
    return allSchedules
        .filter { it.route == this }
        .filter { it.days.contains(day) }
        .flatMap { it.departures.asSequence() }
        .filter { it >= time }
        .map { BusDeparture(this, it) }
        .toList()
}

fun BusRoute.nextDepartures(startingFrom: Instant): List<BusDeparture> {
    return LocalDateTime.ofInstant(startingFrom, ZoneId.systemDefault()).let {
        nextDepartures(DayOfWeek.from(it), it.toTime())
    }
}

fun BusRoute.nextDeparturesToday() = nextDepartures(Calendar.getInstance().toInstant())

fun DayOfWeek.departuresFromAllAvailableRoutes(time: Int): List<BusDeparture> {
    return allSchedules
        .filter { it.days.contains(this) }
        .flatMap { schedule ->
            schedule.departures.asSequence()
                .filter { it >= time }
                .map { BusDeparture(schedule.route, it) }
        }
        .toList()
}

fun departuresFromAllAvailableRoutes(): List<BusDeparture> {
    return Calendar.getInstance().toLocalDateTime().let {
        DayOfWeek.from(it).departuresFromAllAvailableRoutes(it.toTime())
    }
}

fun List<BusDeparture>.distinctRoutes(): List<BusRoute> {
    return asSequence()
        .map { it.route }
        .distinct()
        .toList()
}

fun LocalDateTime.toTime() = hour * 100 + minute
fun Calendar.toLocalDateTime() = LocalDateTime.ofInstant(toInstant(), ZoneId.systemDefault())
fun Calendar.toTime() = toLocalDateTime().toTime()
