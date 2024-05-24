package com.orlov.danylo.core.presentation.recycler_view

class BaseDiffUtilCallback(oldItems: List<ViewHolderItem>, newItems: List<ViewHolderItem>) :
    AbstractDiffCallback<ViewHolderItem>(oldItems, newItems) {

    private val baseDiffCallback = BaseDiffCallback()

    override fun areContentsTheSame(oldItem: ViewHolderItem, newItem: ViewHolderItem): Boolean {
        return baseDiffCallback.areContentsTheSame(oldItem, newItem)
    }

    override fun areItemsTheSame(oldItem: ViewHolderItem, newItem: ViewHolderItem): Boolean {
        return baseDiffCallback.areItemsTheSame(oldItem, newItem)
    }
}