package com.example.felipe.catchthatbus.model

interface ScheduleRepository {
    fun fetchData(): Sequence<BusSchedule>
}