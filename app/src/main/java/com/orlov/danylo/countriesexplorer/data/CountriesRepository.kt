package com.orlov.danylo.countriesexplorer.data

import com.orlov.danylo.countriesexplorer.data.cache.CountriesCacheDataSource
import com.orlov.danylo.countriesexplorer.data.cache.CountriesDao
import com.orlov.danylo.countriesexplorer.data.cache.CountryCache
import com.orlov.danylo.countriesexplorer.data.remote.CountriesRemoteDataSource
import com.orlov.danylo.countriesexplorer.data.remote.model.CountriesList

interface CountriesRepository {

    suspend fun countries(): List<CountryCache>

    abstract class Abstract(
        private val countriesCacheDataSource: CountriesCacheDataSource,
        private val countriesRemoteDataSource: CountriesRemoteDataSource,
        private val countryRemoteListToCacheListMapper: CountryRemoteListToCacheListMapper,
        private val countriesDao: CountriesDao
    ) : CountriesRepository {

        override suspend fun countries(): List<CountryCache> {
            return try {
                val remote = CountriesList.Base(countriesRemoteDataSource.data())
                    .map(countryRemoteListToCacheListMapper)
                countriesDao.insertAll(remote)
                remote
            } catch (e: Exception) {
                e.printStackTrace()
                countriesCacheDataSource.countries()
            }
        }
    }

    class Base(
        cache: CountriesCacheDataSource,
        cloud: CountriesRemoteDataSource,
        mapper: CountryRemoteListToCacheListMapper,
        dao: CountriesDao
    ) : Abstract(cache, cloud, mapper, dao)
}