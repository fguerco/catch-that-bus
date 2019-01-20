package com.example.felipe.catchthatbus.model

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar

fun Sequence<BusSchedule>.nextDepartures(route: BusRoute, day: DayOfWeek, time: Int): Sequence<BusDeparture> {
    return filter { it.route == route }
        .filter { it.days.contains(day) }
        .flatMap { it.departures.asSequence() }
        .filter { it >= time }
        .map { BusDeparture(route, it) }
}

fun Sequence<BusSchedule>.nextDepartures(route: BusRoute, startingFrom: Calendar): Sequence<BusDeparture> {
    return startingFrom.toLocalDateTime().let {
        nextDepartures(route, DayOfWeek.from(it), it.toTime())
    }
}

fun Sequence<BusSchedule>.allDepartures(day: DayOfWeek, time: Int): Sequence<BusDeparture> {
    return filter { it.days.contains(day) }
        .flatMap { schedule ->
            schedule.departures.asSequence()
                .filter { it >= time }
                .map { BusDeparture(schedule.route, it) }
        }
}

fun Sequence<BusSchedule>.allDepartures(date: Calendar): Sequence<BusDeparture> {
    return date.toLocalDateTime().let {
        allDepartures(DayOfWeek.from(it), it.toTime())
    }
}

fun LocalDateTime.toTime() = hour * 100 + minute
fun Calendar.toLocalDateTime() = LocalDateTime.ofInstant(toInstant(), ZoneId.systemDefault())
