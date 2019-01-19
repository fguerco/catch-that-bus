package com.example.felipe.catchthatbus

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.departures.BusDeparture
import kotlinx.android.synthetic.main.departures_list_row.view.departure_time


class DeparturesViewAdapter(
    private val dataset: List<BusDeparture>
) : RecyclerView.Adapter<DeparturesViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount() = dataset.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.departures_list_row, parent, false).let {
                ViewHolder(it)
            }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.departure_time.text = dataset[position].prettyTime()
    }

}