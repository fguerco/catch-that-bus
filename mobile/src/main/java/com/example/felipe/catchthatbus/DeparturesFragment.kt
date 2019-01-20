package com.example.felipe.catchthatbus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_departures.departures_list_view
import kotlinx.android.synthetic.main.fragment_departures.view.departures_list_view
import kotlinx.android.synthetic.main.fragment_departures.view.departures_pull_to_refresh

class DeparturesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_departures, container, false).apply {
            context?.let { departures_list_view.setAdapter(DeparturesListAdapter(it, departures_list_view))  }
            departures_pull_to_refresh.apply {
                setOnRefreshListener {
                    refresh()
                    isRefreshing = false
                }
            }
        }
    }

    fun refresh() = (departures_list_view.expandableListAdapter as DeparturesListAdapter).refresh()
}