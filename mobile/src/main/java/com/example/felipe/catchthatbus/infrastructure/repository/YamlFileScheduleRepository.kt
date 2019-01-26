package com.example.felipe.catchthatbus.infrastructure.repository

import com.example.felipe.catchthatbus.model.BusRoute
import com.example.felipe.catchthatbus.model.RouteSchedule
import com.fasterxml.jackson.databind.ObjectMapper

class YamlFileScheduleRepository(private val mapper: ObjectMapper) : ScheduleRepository {
    override fun allSchedules() = loadFile()?.asSequence()?.map(::mapData) ?: emptySequence()

    private fun mapData(data: ScheduleData) = data.run { RouteSchedule(route, days.toIntList(), departures.toIntList()) }
    private val routesResource get() = javaClass.classLoader?.getResourceAsStream(ROUTES_FILE)

    private fun loadFile() =  routesResource?.use { mapper.readValue(it, Array<ScheduleData>::class.java) }
    private fun String.toIntList() = split(",").map { it.trim().toInt() }

    class ScheduleData {
        lateinit var route: BusRoute
        lateinit var days: String
        lateinit var departures: String
    }
}