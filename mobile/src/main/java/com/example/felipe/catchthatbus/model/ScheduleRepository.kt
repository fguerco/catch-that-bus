package com.example.felipe.catchthatbus.model

interface ScheduleRepository {
    fun allSchedules(): Sequence<RouteSchedule>
}