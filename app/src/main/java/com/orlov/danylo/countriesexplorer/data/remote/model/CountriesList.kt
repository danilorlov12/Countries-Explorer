package com.orlov.danylo.countriesexplorer.data.remote.model

import com.orlov.danylo.core.data.remote.ApiModel

interface CountriesList : ApiModel {

    interface Mapper<T : Any> {
        fun map(countries: List<CountryApiModel.Base>): T
    }

    fun <T : Any> map(mapper: Mapper<T>): T

    data class Base(
        private val countries: List<CountryApiModel.Base>
    ): CountriesList {

        override fun <T : Any> map(mapper: Mapper<T>): T {
            return mapper.map(countries)
        }
    }
}