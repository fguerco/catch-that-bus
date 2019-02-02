package com.example.felipe.catchthatbus.ui.main

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.infrastructure.dayOfMonth
import com.example.felipe.catchthatbus.infrastructure.eventbus.DateSelectedEvent
import com.example.felipe.catchthatbus.infrastructure.month
import com.example.felipe.catchthatbus.infrastructure.today
import com.example.felipe.catchthatbus.infrastructure.year
import com.example.felipe.catchthatbus.ui.EventBusActivity
import com.example.felipe.catchthatbus.ui.departures.DeparturesFragment
import kotlinx.android.synthetic.main.activity_main.toolbar
import org.greenrobot.eventbus.Subscribe
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MainActivity : EventBusActivity() {

    private val dateFormat = SimpleDateFormat("E, dd/MM/yyyy", Locale.getDefault())

    private val date = today()

    private val datePickListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        date.set(year, month, day)
        eventBus.post(DateSelectedEvent(date.timeInMillis))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setToolbarSubtitle(date)
        loadFragment()
    }

    @Subscribe
    fun onDateSelected(event: DateSelectedEvent) {
        date.timeInMillis = event.dateMillis
        setToolbarSubtitle(date)
    }

    private fun loadFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, DeparturesFragment())
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_calendar -> pickDate().let { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun pickDate() {
        DatePickerDialog(this, datePickListener, date.year, date.month, date.dayOfMonth).show()
    }

    private fun setToolbarSubtitle(date: Calendar) {
        toolbar.subtitle = resources.getString(R.string.all_departures).format(dateFormat.format(date.time))
    }
}
