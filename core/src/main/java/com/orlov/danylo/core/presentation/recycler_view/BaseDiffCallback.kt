package com.orlov.danylo.core.presentation.recycler_view

import androidx.recyclerview.widget.DiffUtil

class BaseDiffCallback : DiffUtil.ItemCallback<ViewHolderItem>() {
    override fun areItemsTheSame(oldItem: ViewHolderItem, newItem: ViewHolderItem): Boolean {
        return oldItem.areItemsTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: ViewHolderItem, newItem: ViewHolderItem): Boolean {
        return oldItem.areContentsTheSame(newItem)
    }
}