package com.example.felipe.catchthatbus.infrastructure.repository

import com.example.felipe.catchthatbus.model.routesOf
import java.util.Calendar

class DepartureRepository(private val scheduleRepository: ScheduleRepository) {
    fun routesOf(date: Calendar) = scheduleRepository.allSchedules().routesOf(date).toList()
}