package com.example.felipe.catchthatbus.ui.departures

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.felipe.catchthatbus.R
import com.example.felipe.catchthatbus.infrastructure.Services
import com.example.felipe.catchthatbus.model.BusRoute
import com.example.felipe.catchthatbus.ui.GridVerticalAutofitLayoutManager
import kotlinx.android.synthetic.main.routes_view_holder.view.departures_recycler_view
import kotlinx.android.synthetic.main.routes_view_holder.view.group_route_name
import java.time.Instant

class RoutesRecyclerViewAdapter(dataset: List<BusRoute>) :
        RecyclerView.Adapter<RoutesRecyclerViewAdapter.ViewHolder>() {

    private val data = dataset.toMutableList()
    private val viewPool = RecyclerView.RecycledViewPool()
    private val repository by lazy { Services.departureRepository }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return LayoutInflater
            .from(parent.context)
            .inflate(R.layout.routes_view_holder, parent, false)
            .let { ViewHolder(it) }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        data[position].let {
            holder.route.text = holder.itemView.context.getText(it.resId)
            holder.recyclerView.apply {
                adapter = DeparturesRecyclerViewAdapter(repository.departuresToday(it))
                layoutManager = GridVerticalAutofitLayoutManager(holder.itemView.context, 167)
                setRecycledViewPool(viewPool)
            }
        }
    }

    override fun getItemCount() = data.size

    fun clear() {
        data.clear()
        notifyDataSetChanged()
    }

    fun putItems(items: List<BusRoute>) {
        data.addAll(items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val recyclerView = item.departures_recycler_view
        val route = item.group_route_name
    }

}