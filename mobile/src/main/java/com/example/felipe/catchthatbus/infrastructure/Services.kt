package com.example.felipe.catchthatbus.infrastructure

import com.example.felipe.catchthatbus.infrastructure.repository.ClasspathYamlDataSource
import com.example.felipe.catchthatbus.infrastructure.repository.DepartureRepository
import com.example.felipe.catchthatbus.infrastructure.repository.ScheduleRepository
import com.example.felipe.catchthatbus.infrastructure.repository.YamlDocumentScheduleRepository
import org.greenrobot.eventbus.EventBus

object Services {
    val scheduleRepository: ScheduleRepository by lazy { YamlDocumentScheduleRepository(ClasspathYamlDataSource()) }
    val departureRepository by lazy { DepartureRepository(scheduleRepository) }
    val eventBus by lazy { EventBus.getDefault()!! }
}