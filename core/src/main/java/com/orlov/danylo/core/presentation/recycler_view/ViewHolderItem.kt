package com.orlov.danylo.core.presentation.recycler_view

interface ViewHolderItem {
    fun areItemsTheSame(other: Any): Boolean
    fun areContentsTheSame(other: Any): Boolean
}