package com.orlov.danylo.core.presentation.recycler_view

fun interface OnItemClickListener<in T> {
    fun onItemClick(item: T)
}