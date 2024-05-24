package com.orlov.danylo.countriesexplorer.domain

import com.orlov.danylo.countriesexplorer.data.cache.CountryCache

interface CountryCacheToDomainMapper : CountryCache.Mapper<Country> {

    class Base : CountryCacheToDomainMapper {

        override fun map(name: String, area: String): Country {
            return Country.Base(name, area)
        }
    }
}
