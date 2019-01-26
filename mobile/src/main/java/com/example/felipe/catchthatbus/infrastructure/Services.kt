package com.example.felipe.catchthatbus.infrastructure

import com.example.felipe.catchthatbus.infrastructure.repository.DepartureRepository
import com.example.felipe.catchthatbus.infrastructure.repository.ScheduleRepository
import com.example.felipe.catchthatbus.infrastructure.repository.YamlFileScheduleRepository
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

object Services {
    val mapper by lazy { ObjectMapper(YAMLFactory()).registerKotlinModule() }

    val scheduleRepository: ScheduleRepository by lazy { YamlFileScheduleRepository(mapper) }
    val departureRepository by lazy { DepartureRepository(scheduleRepository) }
}