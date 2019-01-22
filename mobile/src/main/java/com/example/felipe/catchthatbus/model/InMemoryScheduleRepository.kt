package com.example.felipe.catchthatbus.model

import com.example.felipe.catchthatbus.model.data.allSchedules

class InMemoryScheduleRepository : ScheduleRepository {
    override fun allSchedules(): Sequence<RouteSchedule> = allSchedules
}

