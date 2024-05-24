package com.orlov.danylo.countriesexplorer.domain

import android.widget.TextView
import com.orlov.danylo.core.presentation.recycler_view.ViewHolderItem

interface Country : ViewHolderItem {

    interface Mapper<T : Any> {

        fun map(name: String, area: String): T

        class ApplyToView(
            private val tvName: TextView,
            private val tvArea: TextView
        ) : Mapper<Unit> {
            override fun map(name: String, area: String) {
                tvName.text = name
                tvArea.text = area
            }
        }
    }

    fun <T : Any> map(mapper: Mapper<T>): T

    data class Base(
        private val name: String,
        private val area: String
    ) : Country {

        override fun <T : Any> map(mapper: Mapper<T>): T = mapper.map(name, area)

        override fun areContentsTheSame(other: Any): Boolean {
            return other is Base
                    && other.name == this.name
                    && other.area == this.area
        }

        override fun areItemsTheSame(other: Any): Boolean {
            return other is Base && other.name == this.name
        }
    }
}
