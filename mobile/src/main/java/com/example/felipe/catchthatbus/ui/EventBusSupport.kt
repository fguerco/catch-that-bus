package com.example.felipe.catchthatbus.ui

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.felipe.catchthatbus.infrastructure.Services

abstract class EventBusActivity : AppCompatActivity() {
    protected val eventBus = Services.eventBus

    override fun onStart() {
        super.onStart()
        eventBus.register(this)
    }

    override fun onStop() {
        super.onStop()
        eventBus.unregister(this)
    }
}

abstract class EventBusFragment : Fragment() {
    protected val eventBus = Services.eventBus

    override fun onStart() {
        super.onStart()
        eventBus.register(this)
    }

    override fun onStop() {
        super.onStop()
        eventBus.unregister(this)
    }
}