package com.orlov.danylo.core.presentation.recycler_view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<M: Any, VH: BaseViewHolder<M>> : RecyclerView.Adapter<VH>() {

    private var onItemClickListener: OnItemClickListener<M>? = null
    private var inflater: LayoutInflater? = null
    private val dataList = mutableListOf<M>()

    abstract fun getDiffCallback(oldItems: List<M>, newItems: List<M>): DiffUtil.Callback

    override fun getItemCount(): Int = dataList.size

    fun getItem(position: Int): M {
        return dataList[position]
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position), onItemClickListener)
    }

    override fun onViewAttachedToWindow(holder: VH) {
        super.onViewAttachedToWindow(holder)
        holder.setOnClickListener(onItemClickListener)
        holder.onAttachedToRecycler(this)
    }

    override fun onViewDetachedFromWindow(holder: VH) {
        super.onViewDetachedFromWindow(holder)
        holder.onDetachedFromRecycler()
    }

    private fun layoutInflater(context: Context): LayoutInflater {
        if (inflater == null) {
            inflater = LayoutInflater.from(context)
        }
        return inflater!!
    }

    fun submitList(list: List<M>?) {
        val callback = getDiffCallback(dataList, list.orEmpty())
        DiffUtil.calculateDiff(callback, true).dispatchUpdatesTo(this)
        dataList.clear()
        dataList.addAll(list.orEmpty())
    }
}