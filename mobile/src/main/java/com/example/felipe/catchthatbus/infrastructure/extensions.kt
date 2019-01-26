package com.example.felipe.catchthatbus.infrastructure

inline fun <reified T: Any> Any?.asTypedList() = (this as? List<*>)?.mapNotNull { it as? T }  ?: emptyList()