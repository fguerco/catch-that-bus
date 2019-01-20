package com.example.felipe.catchthatbus.ui.departures

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.model.BusDeparture
import kotlinx.android.synthetic.main.departures_view_holder.view.departure_time

class DeparturesRecyclerViewAdapter(dataset: List<BusDeparture>) :
        RecyclerView.Adapter<DeparturesRecyclerViewAdapter.ViewHolder>() {

    private val data = dataset.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.departures_view_holder, parent, false)
            .let { ViewHolder(it) }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.departureTime.text = data[position].prettyTime()
    }

    override fun getItemCount() = data.size

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun putItems(items: List<BusDeparture>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val departureTime = item.departure_time
    }

}