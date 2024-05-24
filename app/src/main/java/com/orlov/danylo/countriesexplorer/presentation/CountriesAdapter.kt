package com.orlov.danylo.countriesexplorer.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.orlov.danylo.core.presentation.recycler_view.BaseAdapter
import com.orlov.danylo.core.presentation.recycler_view.BaseDiffUtilCallback
import com.orlov.danylo.core.presentation.recycler_view.BaseViewHolder
import com.orlov.danylo.countriesexplorer.R
import com.orlov.danylo.countriesexplorer.domain.Country

class CountriesAdapter : BaseAdapter<Country, CountryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val country = getItem(position)
        country.map(Country.Mapper.ApplyToView(holder.tvName, holder.tvArea))
    }

    override fun getDiffCallback(oldItems: List<Country>, newItems: List<Country>): DiffUtil.Callback {
        return BaseDiffUtilCallback(oldItems, newItems)
    }
}

class CountryViewHolder(view: View) : BaseViewHolder<Country>(view) {
    val tvName: TextView = view.findViewById(R.id.tvName)
    val tvArea: TextView = view.findViewById(R.id.tvArea)
}