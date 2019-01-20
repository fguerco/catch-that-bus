package com.example.felipe.catchthatbus.ui.departures

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.departures.allDepartures
import com.example.felipe.catchthatbus.departures.distinctRoutes
import kotlinx.android.synthetic.main.fragment_departures.departures_refresh
import kotlinx.android.synthetic.main.fragment_departures.routes_recycler_view
import kotlinx.android.synthetic.main.fragment_departures.view.departures_refresh
import kotlinx.android.synthetic.main.fragment_departures.view.routes_recycler_view
import java.util.Calendar

class DeparturesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_departures, container, false).apply {
            routes_recycler_view.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = RoutesRecyclerViewAdapter(getData())
            }

            departures_refresh.setOnRefreshListener(::refresh)
        }
    }

    fun refresh() {
        (routes_recycler_view.adapter as RoutesRecyclerViewAdapter).apply {
            clear()
            putItems(getData())
        }
        departures_refresh.isRefreshing = false
    }

    private fun getData() = Calendar.getInstance().allDepartures().distinctRoutes()
}