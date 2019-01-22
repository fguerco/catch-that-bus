package com.example.felipe.catchthatbus.model

data class BusSchedule(val route: BusRoute, val days: List<Int>, val departures: List<Int>)
