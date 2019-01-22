package com.example.felipe.catchthatbus.ui.departures

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.model.RouteSchedule
import com.example.felipe.catchthatbus.ui.GridVerticalAutofitLayoutManager
import kotlinx.android.synthetic.main.routes_view_holder.view.departures_recycler_view
import kotlinx.android.synthetic.main.routes_view_holder.view.group_route_name

class RoutesRecyclerViewAdapter(dataset: List<RouteSchedule>) :
        RecyclerView.Adapter<RoutesRecyclerViewAdapter.ViewHolder>() {

    private val data = dataset.toMutableList()
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater
            .from(parent.context)
            .inflate(R.layout.routes_view_holder, parent, false)
            .let { ViewHolder(it) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].let {
            holder.route.text = holder.itemView.context.getText(it.route.resId)
            holder.recyclerView.apply {
                adapter = DeparturesRecyclerViewAdapter(it.departures)
                holder.itemView.context.apply {
                    layoutManager = GridVerticalAutofitLayoutManager(this, departuresTextViewWidth)
                }

                setRecycledViewPool(viewPool)
            }
        }
    }

    override fun getItemCount() = data.size

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun putItems(items: List<RouteSchedule>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    private val Context.departuresTextViewWidth get() = resources.getDimension(R.dimen.departure_text_view_width).toInt()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView = item.departures_recycler_view!!
        val route = item.group_route_name!!
    }

}