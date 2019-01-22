package com.example.felipe.catchthatbus.model

import java.util.Calendar

class DepartureRepository(private val scheduleRepository: ScheduleRepository) {

    private fun departuresToday() = scheduleRepository.fetchData().allDepartures(Calendar.getInstance())
    private fun allDepartures() = scheduleRepository.fetchData().allDepartures()

    fun allRoutes() = allDepartures().map { it.route }.distinct().toList()
    fun routesToday() = departuresToday().map { it.route }.distinct().toList()

    fun allDepartures(route: BusRoute) = allDepartures().filter { it.route == route }.toList()
    fun departuresToday(route: BusRoute) = departuresToday().filter { it.route == route }.toList()
}