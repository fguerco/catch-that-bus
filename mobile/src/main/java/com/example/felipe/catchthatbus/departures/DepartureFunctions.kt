package com.example.felipe.catchthatbus.departures

import java.time.DayOfWeek
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

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
    val localTime = LocalDateTime.ofInstant(startingFrom, ZoneId.systemDefault())
    val time = localTime.hour * 100 + localTime.minute
    return nextDepartures(DayOfWeek.from(localTime), time)
}

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