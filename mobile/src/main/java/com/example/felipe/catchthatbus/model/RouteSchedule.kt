package com.example.felipe.catchthatbus.model

import com.example.felipe.catchthatbus.infrastructure.asTypedList

const val ROUTE_KEY = "route"
const val DAYS_KEY = "days"
const val DEPARTURES_KEY = "departures"

data class RouteSchedule(val route: BusRoute, val days: List<Int>, val departures: List<Int>) {

    constructor(data: Map<String, Any>) : this(data[ROUTE_KEY].asBusRoute(),
                                               data[DAYS_KEY].asTypedList(),
                                               data[DEPARTURES_KEY].asTypedList())

}
