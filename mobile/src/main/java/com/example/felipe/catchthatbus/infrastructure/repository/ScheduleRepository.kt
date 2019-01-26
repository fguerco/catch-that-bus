package com.example.felipe.catchthatbus.infrastructure.repository

import com.example.felipe.catchthatbus.model.RouteSchedule

interface ScheduleRepository {
    fun allSchedules(): Sequence<RouteSchedule>
}