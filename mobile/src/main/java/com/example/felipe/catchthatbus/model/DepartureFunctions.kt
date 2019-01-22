package com.example.felipe.catchthatbus.model

import java.util.Calendar

fun Sequence<BusSchedule>.nextDepartures(route: BusRoute, day: Int, time: Int): Sequence<BusDeparture> {
    return filter { it.route == route }
        .filter { it.days.contains(day) }
        .flatMap { it.departures.asSequence() }
        .filter { it >= time }
        .map { BusDeparture(route, it) }
}

fun Sequence<BusSchedule>.nextDepartures(route: BusRoute, startingFrom: Calendar): Sequence<BusDeparture> {
    return nextDepartures(route, startingFrom.dayOfWeek, startingFrom.intTime)
}

fun Sequence<BusSchedule>.allDepartures(day: Int, time: Int): Sequence<BusDeparture> {
    return filter { it.days.contains(day) }
        .flatMap { schedule ->
            schedule.departures.asSequence()
                .filter { it >= time }
                .map { BusDeparture(schedule.route, it) }
        }
}

fun Sequence<BusSchedule>.allDepartures(startingFrom: Calendar) = allDepartures(startingFrom.dayOfWeek, startingFrom.intTime)

val Calendar.intTime get() = get(Calendar.HOUR_OF_DAY) * 100 + get(Calendar.MINUTE)
val Calendar.dayOfWeek get() = get(Calendar.DAY_OF_WEEK)
