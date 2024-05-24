package com.orlov.danylo.countriesexplorer.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

interface CountryCache {

    interface Mapper<T : Any> {
        fun map(name: String, area: String): T
    }

    fun <T : Any> map(mapper: Mapper<T>): T

    @Entity(tableName = "Countries")
    data class Base(
        @PrimaryKey
        @SerializedName("_name") val name: String,
        @SerializedName("area") val area: String
    ) : CountryCache {

        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.map(name, area)
        }
    }
}