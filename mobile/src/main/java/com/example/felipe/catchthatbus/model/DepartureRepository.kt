package com.example.felipe.catchthatbus.model

import java.util.Calendar

class DepartureRepository(private val scheduleRepository: ScheduleRepository) {

    private fun departuresToday() = scheduleRepository.fetchData().allDepartures(Calendar.getInstance())

    fun routesToday() = departuresToday().map { it.route }.distinct().toList()
    fun departuresToday(route: BusRoute) = departuresToday().filter { it.route == route }.toList()
}