package com.example.felipe.catchthatbus.model

class InMemoryScheduleRepository : ScheduleRepository {
    override fun fetchData(): Sequence<BusSchedule> = allSchedules
}

