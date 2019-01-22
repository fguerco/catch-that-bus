package com.example.felipe.catchthatbus.model

import java.util.Calendar

class DepartureRepository(private val scheduleRepository: ScheduleRepository) {
    fun routesOf(date: Calendar) = scheduleRepository.allSchedules().routesOf(date).toList()
}