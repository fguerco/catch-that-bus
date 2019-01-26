package com.example.felipe.catchthatbus.infrastructure.repository

import com.example.felipe.catchthatbus.model.RouteSchedule
import org.yaml.snakeyaml.Yaml

typealias YamlDataType = List<Map<String, Any>>

class YamlDocumentScheduleRepository(private val yamlDataSource: YamlDataSource) : ScheduleRepository {

    override fun allSchedules() = loadFile().asSequence()

    private fun loadFile() =  yamlDataSource.load(ROUTES_FILE).let { data ->
        Yaml().load<YamlDataType>(data)?.map { RouteSchedule(it) } ?: emptyList()
    }
}
