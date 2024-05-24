package com.orlov.danylo.countriesexplorer.data.cache

import com.google.gson.reflect.TypeToken
import com.orlov.danylo.core.data.Serialization
import com.orlov.danylo.core.data.StringProvider

interface CountriesCacheDataSource {

    suspend fun countries(): List<CountryCache.Base>

    class Dao(
        private val dao: CountriesDao
    ) : CountriesCacheDataSource {
        override suspend fun countries(): List<CountryCache.Base> = dao.countries()
    }

    class LocalSamples(
        private val stringProvider: StringProvider,
        private val serialization: Serialization
    ) : CountriesCacheDataSource {

        override suspend fun countries(): List<CountryCache.Base> {
            val string = stringProvider.provide()
            if (string.isBlank()) return emptyList()
            val type = object : TypeToken<ArrayList<CountryCache.Base>>() {}.type
            return serialization.fromJson(string, type)
        }
    }

    open class WithAlternative(
        private val main: CountriesCacheDataSource,
    ) : CountriesCacheDataSource {
        override suspend fun countries(): List<CountryCache.Base> {
            return main.countries()
        }
    }

    class Base(
        dao: CountriesDao,
        serialization: Serialization
    ) : WithAlternative(
        Dao(dao),
    )
}
