package com.example.felipe.catchthatbus.model

import java.time.DayOfWeek

data class BusSchedule(val route: BusRoute, val days: List<DayOfWeek>, val departures: List<Int>)
