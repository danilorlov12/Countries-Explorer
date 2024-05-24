package com.orlov.danylo.countriesexplorer.domain

import com.orlov.danylo.core.domain.UseCase
import com.orlov.danylo.countriesexplorer.data.CountriesRepository
import com.orlov.danylo.countriesexplorer.data.cache.CountryCache

interface AllCountriesUseCase : UseCase {

    suspend fun countries(): List<Country>

    class Base(
        private val repository: CountriesRepository,
        private val mapper: CountryCacheToDomainMapper
    ) : AllCountriesUseCase {

        override suspend fun countries(): List<Country> {
            return repository.countries().map { it.map(mapper) }
        }
    }
}