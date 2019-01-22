package com.example.felipe.catchthatbus.model

import java.io.Serializable

data class BusDeparture(val route: BusRoute, val time: Int) : Serializable {

}