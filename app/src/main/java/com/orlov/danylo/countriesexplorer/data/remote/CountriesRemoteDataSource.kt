package com.orlov.danylo.countriesexplorer.data.remote

import com.orlov.danylo.core.data.DataSource
import com.orlov.danylo.core.data.remote.AbstractRemoteDataSource
import com.orlov.danylo.countriesexplorer.data.remote.model.CountryApiModel

interface CountriesRemoteDataSource : DataSource<List<CountryApiModel.Base>> {

    abstract class Abstract(
        private val countriesService: CountriesService
    ) : AbstractRemoteDataSource("/all"), CountriesRemoteDataSource {

        override suspend fun data(): List<CountryApiModel.Base> {
            return handle {
                countriesService.countries()
            }
        }
    }

    class Base(service: CountriesService) : CountriesRemoteDataSource.Abstract(service)
}