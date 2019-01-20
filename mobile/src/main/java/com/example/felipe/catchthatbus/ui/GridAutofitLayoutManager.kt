package com.example.felipe.catchthatbus.ui

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue



class GridVerticalAutofitLayoutManager(
    private val context: Context,
    columnWidth: Int = 1,
    reverseLayout: Boolean = false
) : GridLayoutManager(context, 1, LinearLayoutManager.VERTICAL, reverseLayout) {

    private val defaultWidth by lazy {
        TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP, 48f, context.resources.displayMetrics
        ).toInt()
    }

    private var widthChanged = true

    private var calculatedWidth = columnWidth
        set(value) {
            if (value > 0 && value != field) {
                field = value
                widthChanged = true
            }
        }

    init {
        calculatedWidth = checkedWidth(columnWidth)
    }

    private fun checkedWidth(width: Int) = if (width > 0) width else defaultWidth

    override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
        if (widthChanged && calculatedWidth > 0 && width > 0) {

            val totalSpace = width - paddingRight - paddingLeft
            spanCount =  Math.max(1, totalSpace.div(calculatedWidth))
            widthChanged = false
        }

        super.onLayoutChildren(recycler, state)
    }
}