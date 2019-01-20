package com.example.felipe.catchthatbus

import android.content.Context
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ExpandableListView
import com.example.felipe.catchthatbus.departures.BusDeparture
import com.example.felipe.catchthatbus.departures.BusRoute
import com.example.felipe.catchthatbus.departures.allDepartures
import com.example.felipe.catchthatbus.departures.distinctRoutes
import kotlinx.android.synthetic.main.departures_list_group.view.group_route_name
import kotlinx.android.synthetic.main.departures_list_row.view.departure_time
import java.util.Calendar

/**
 * A [FragmentStatePagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class DeparturesListAdapter(private val context: Context, private val listView: ExpandableListView) : BaseExpandableListAdapter() {
    private lateinit var departures: List<BusDeparture>
    private lateinit var routes: List<BusRoute>

    init {
        retrieveData()
    }

    fun refresh() {
        retrieveData()
        collapseAll()
        notifyDataSetChanged()
    }

    private fun BusRoute.departures() = departures.filter { it.route == this }

    private fun retrieveData() {
        departures = Calendar.getInstance().allDepartures()
        routes = departures.distinctRoutes()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {

        return (convertView ?: LayoutInflater.from(context).inflate(R.layout.departures_list_group, parent, false)).apply {
            group_route_name.text = context.getString(getGroup(groupPosition).resId)
        }
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        return (convertView ?: LayoutInflater.from(context).inflate(R.layout.departures_list_row, parent, false)).apply {
            departure_time.text = getChild(groupPosition, childPosition).prettyTime()
        }
    }

    override fun onGroupExpanded(groupPosition: Int) {
        (0..groupCount.dec()).minus(groupPosition).forEach {
            listView.collapseGroup(it)
        }
    }

    fun collapseAll() {
        (0..groupCount.dec()).forEach { listView.collapseGroup(it) }
    }

    override fun getGroup(groupPosition: Int) = routes[groupPosition]
    override fun isChildSelectable(groupPosition: Int, childPosition: Int) = true
    override fun hasStableIds() = false
    override fun getChildrenCount(groupPosition: Int) = routes[groupPosition].departures().size
    override fun getChild(groupPosition: Int, childPosition: Int) = routes[groupPosition].departures()[childPosition]
    override fun getGroupId(groupPosition: Int) = groupPosition.toLong()
    override fun getChildId(groupPosition: Int, childPosition: Int) = childPosition.toLong()
    override fun getGroupCount() = routes.size
}