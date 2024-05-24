package com.orlov.danylo.countriesexplorer.data

import com.orlov.danylo.countriesexplorer.data.cache.CountryCache
import com.orlov.danylo.countriesexplorer.data.remote.model.CountriesList
import com.orlov.danylo.countriesexplorer.data.remote.model.CountryApiModel

interface CountryRemoteListToCacheListMapper : CountriesList.Mapper<List<CountryCache.Base>> {

    class Base(
        private val mapper: CountryRemoteToCacheMapper
    ) : CountryRemoteListToCacheListMapper {

        override fun map(countries: List<CountryApiModel.Base>): List<CountryCache.Base> {
            return countries.map { it.map(mapper) }
        }
    }
}
