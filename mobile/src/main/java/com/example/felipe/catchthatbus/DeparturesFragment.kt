package com.example.felipe.catchthatbus

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.departures.BusDeparture
import com.example.felipe.catchthatbus.departures.BusRoute
import kotlinx.android.synthetic.main.fragment_departures.view.departures_list_view
import kotlinx.android.synthetic.main.fragment_departures.view.route_name

/**
 * A placeholder fragment containing a simple view.
 */
class DeparturesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        rootView.route_name.text = getString(route.resId)

        val viewManager = LinearLayoutManager(context)
        val adapter = DeparturesViewAdapter(departures.toList())

        rootView.departures_list_view.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            this.adapter = adapter
            itemAnimator = DefaultItemAnimator()
        }

        StringBuilder().apply {
            departures
                .filter { it.route == route }
                .forEach { appendln(it.prettyTime()) }

            //rootView.section_label.text = toString()
        }

        return rootView
    }

    private val departures: Sequence<BusDeparture> by lazy {
        (arguments?.getSerializable("departures") as? ArrayList<*> ?: emptyList<BusDeparture>())
            .asSequence().mapNotNull { it as? BusDeparture }
    }

    private val route: BusRoute by lazy {
        arguments?.getInt("route")?.let {
            BusRoute.values()[it]
        } ?: throw IllegalArgumentException("No route selected")
    }

    companion object {
        fun newInstance(route: BusRoute, departures: List<BusDeparture>): DeparturesFragment {
            val fragment = DeparturesFragment()
            val args = Bundle()
            args.putInt("route", route.ordinal)
            args.putSerializable("departures", ArrayList(departures))
            fragment.arguments = args
            return fragment
        }
    }
}