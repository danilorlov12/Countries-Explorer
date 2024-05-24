package com.orlov.danylo.countriesexplorer.data

import com.orlov.danylo.countriesexplorer.data.cache.CountryCache
import com.orlov.danylo.countriesexplorer.data.remote.model.CountryApiModel

interface CountryRemoteToCacheMapper : CountryApiModel.Mapper<CountryCache.Base> {

    class Base : CountryRemoteToCacheMapper {

        override fun map(
            area: Double,
            flag: String,
            name: String
        ) = CountryCache.Base(name, area.toString())
    }
}
