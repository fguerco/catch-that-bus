package com.example.felipe.catchthatbus.ui.departures

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.infrastructure.Services
import kotlinx.android.synthetic.main.fragment_departures.departures_refresh
import kotlinx.android.synthetic.main.fragment_departures.routes_recycler_view
import kotlinx.android.synthetic.main.fragment_departures.view.departures_refresh
import kotlinx.android.synthetic.main.fragment_departures.view.routes_recycler_view
import java.util.Calendar
import java.util.GregorianCalendar

const val DATE = "date"

class DeparturesFragment : Fragment() {

    private val repository by lazy { Services.departureRepository }
    private val recyclerViewAdapter by lazy { routes_recycler_view.adapter as RoutesRecyclerViewAdapter }

    private var date: Calendar = arguments?.getSerializable(DATE) as? Calendar ?: GregorianCalendar()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_departures, container, false).apply {
            routes_recycler_view.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = RoutesRecyclerViewAdapter(fetchData())
            }

            departures_refresh.setOnRefreshListener(::refresh)
            setHasOptionsMenu(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_refresh -> refresh().let { true }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun refresh() {
        departures_refresh.isRefreshing = true
        date = GregorianCalendar()
        recyclerViewAdapter.apply {
            clear()
            putItems(fetchData())
        }
        departures_refresh.isRefreshing = false
    }

    private fun fetchData() = repository.routesOf(date)

}