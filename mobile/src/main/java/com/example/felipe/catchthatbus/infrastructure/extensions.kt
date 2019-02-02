package com.example.felipe.catchthatbus.infrastructure

import java.util.Calendar
import kotlin.reflect.KProperty

inline fun <reified T: Any> Any?.asTypedList() = (this as? List<*>)?.mapNotNull { it as? T }  ?: emptyList()

var Calendar.year by CalendarFieldDelegate(Calendar.YEAR)
var Calendar.month by CalendarFieldDelegate(Calendar.MONTH)
var Calendar.dayOfMonth by CalendarFieldDelegate(Calendar.DAY_OF_MONTH)
var Calendar.hourOfDay by CalendarFieldDelegate(Calendar.HOUR_OF_DAY)
var Calendar.minute by CalendarFieldDelegate(Calendar.MINUTE)
var Calendar.second by CalendarFieldDelegate(Calendar.SECOND)

fun Int.fullDate(date: Calendar): Calendar = (date.clone() as Calendar).also {
    it.hourOfDay = this / 100
    it.minute = this % 100
}

fun today() = Calendar.getInstance().apply {
    second = 0
}

private class CalendarFieldDelegate(private val field: Int) {
    operator fun getValue(thisRef: Calendar, property: KProperty<*>): Int {
        return thisRef.get(field)
    }
    operator fun setValue(thisRef: Calendar, property: KProperty<*>, value: Int) {
        thisRef.set(field, value)
    }
}
