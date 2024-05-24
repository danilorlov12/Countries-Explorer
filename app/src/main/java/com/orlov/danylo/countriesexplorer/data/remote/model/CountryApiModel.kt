package com.orlov.danylo.countriesexplorer.data.remote.model

import com.google.gson.annotations.SerializedName
import com.orlov.danylo.core.data.remote.ApiModel

interface CountryApiModel : ApiModel {

    interface Mapper<T : Any> {
        fun map(
            area: Double,
            flag: String,
            name: String
        ): T
    }

    fun <T : Any> map(mapper: Mapper<T>): T

    data class Base(
        @SerializedName("area") val area: Double,
        @SerializedName("flag") val flag: String,
        @SerializedName("name") val name: CountryName
    ): CountryApiModel {

        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.map(area, flag, name.official)
        }
    }
}