package com.example.felipe.catchthatbus.ui.departures

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.infrastructure.fullDate
import com.example.felipe.catchthatbus.infrastructure.today
import kotlinx.android.synthetic.main.departures_view_holder.view.departure_time
import java.util.Calendar

class DeparturesRecyclerViewAdapter(dataset: List<Int>, private val date: Calendar) :
        RecyclerView.Adapter<DeparturesRecyclerViewAdapter.ViewHolder>() {

    private val data = dataset.toMutableList()
    private val today = today()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        LayoutInflater.from(parent.context)
            .inflate(R.layout.departures_view_holder, parent, false)
            .let { ViewHolder(it) }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alpha = if (data[position].fullDate(date).before(today)) 50 else 190

        holder.departureTime.apply {
            text = data[position].prettyTime
            setTextColor(textColors.withAlpha(alpha))
        }
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

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val departureTime = item.departure_time!!
    }

}