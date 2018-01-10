package com.ooftf.straight

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.AttributeSet
import android.widget.LinearLayout

/**
 * Created by 99474 on 2017/11/1 0001.
 */

class StraightListView : LinearLayout {
    internal var adapter: Adapter<out RecyclerView.ViewHolder>? = null
    internal var observer: RecyclerView.AdapterDataObserver = object : RecyclerView.AdapterDataObserver() {
        override fun onChanged() {
            relayoutChild()
        }
    }

    fun relayoutChild() {
        removeAllViews()
        adapter?.let {
            for (i in 0 until it.itemCount) {
                it as RecyclerView.Adapter<RecyclerView.ViewHolder>
                val viewHolder = it.onCreateViewHolder(this@StraightListView, it.getItemViewType(i))
                it.onBindViewHolder(viewHolder, i)
                addView(viewHolder.itemView)
            }
        }
    }

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {}

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {}

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
    }

    fun setAdapter(adapter: Adapter<out RecyclerView.ViewHolder>) {
        this.adapter?.unregisterAdapterDataObserver(observer)
        this.adapter = adapter
        adapter.registerAdapterDataObserver(observer)
        relayoutChild()
    }
}
