package com.example.felipe.catchthatbus.ui.departures

import android.support.v4.widget.TextViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import kotlinx.android.synthetic.main.departures_view_holder.view.departure_time
import java.util.Calendar
import java.util.GregorianCalendar

class DeparturesRecyclerViewAdapter(dataset: List<Int>) :
        RecyclerView.Adapter<DeparturesRecyclerViewAdapter.ViewHolder>() {

    private val data = dataset.toMutableList()
    private val today = GregorianCalendar()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.departures_view_holder, parent, false)
            .let { ViewHolder(it) }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.departureTime.text = data[position].prettyTime

        if (today.isAfter(data[position]))
            TextViewCompat.setTextAppearance(holder.departureTime, R.style.text_unavailable_time)
    }

    override fun getItemCount() = data.size

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun putItems(items: List<Int>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    private val Int.prettyTime get() = String.format("%04d", this).run {
        substring(0..1) + ":" + substring(2..3)
    }

    private fun Calendar.isAfter(time: Int) = get(Calendar.HOUR_OF_DAY) * 100 + get(Calendar.MINUTE) > time

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val departureTime = item.departure_time!!
    }

}