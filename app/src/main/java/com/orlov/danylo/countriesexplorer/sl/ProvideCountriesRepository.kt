package com.orlov.danylo.countriesexplorer.sl

import com.orlov.danylo.core.data.Serialization
import com.orlov.danylo.core.data.retrorfit.CreateService
import com.orlov.danylo.core.data.retrorfit.ProvideGson
import com.orlov.danylo.core.sl.ProvideRepository
import com.orlov.danylo.countriesexplorer.data.CountriesRepository
import com.orlov.danylo.countriesexplorer.data.CountryRemoteListToCacheListMapper
import com.orlov.danylo.countriesexplorer.data.CountryRemoteToCacheMapper
import com.orlov.danylo.countriesexplorer.data.cache.CountriesCacheDataSource
import com.orlov.danylo.countriesexplorer.data.cache.CountriesDao
import com.orlov.danylo.countriesexplorer.data.remote.CountriesRemoteDataSource
import com.orlov.danylo.countriesexplorer.data.remote.CountriesService

interface ProvideCountriesRepository : ProvideRepository<CountriesRepository> {

    class Base(
        private val provideDao: ProvideDao,
        private val createService: CreateService
    ) : ProvideCountriesRepository {

        private val serialization = Serialization.Base(ProvideGson.Base())
        private val quoteCloudToCacheMapper: CountryRemoteListToCacheListMapper =
            CountryRemoteListToCacheListMapper.Base(CountryRemoteToCacheMapper.Base())

        private fun quoteCacheDataSource(): CountriesCacheDataSource {
            return CountriesCacheDataSource.Base(
                provideDao.provide(CountriesDao::class.java),
                serialization
            )
        }

        private fun quotesCloudDataSource(): CountriesRemoteDataSource {
            return CountriesRemoteDataSource.Base(createService.create(CountriesService::class.java))
        }

        override fun provide(): CountriesRepository {
            return CountriesRepository.Base(
                quoteCacheDataSource(),
                quotesCloudDataSource(),
                quoteCloudToCacheMapper,
                provideDao.provide(CountriesDao::class.java)
            )
        }
    }
}
