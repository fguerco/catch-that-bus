package com.example.felipe.catchthatbus.departures

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class BusDeparture(val route: BusRoute, val time: Int) : Serializable {
    fun prettyTime() = String.format("%04d", time).run {
        substring(0..1) + ":" + substring(2..3)
    }
}