package com.example.felipe.catchthatbus.infrastructure

import com.example.felipe.catchthatbus.model.DepartureRepository
import com.example.felipe.catchthatbus.model.InMemoryScheduleRepository
import com.example.felipe.catchthatbus.model.ScheduleRepository

object Services {
    val scheduleRepository: ScheduleRepository by lazy { InMemoryScheduleRepository() }
    val departureRepository by lazy { DepartureRepository(scheduleRepository) }
}