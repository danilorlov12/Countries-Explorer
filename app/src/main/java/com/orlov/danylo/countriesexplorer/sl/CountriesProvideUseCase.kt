package com.orlov.danylo.countriesexplorer.sl

import com.orlov.danylo.core.domain.UseCase
import com.orlov.danylo.core.sl.ProvideRepository
import com.orlov.danylo.core.sl.ProvideUseCase
import com.orlov.danylo.countriesexplorer.data.CountriesRepository
import com.orlov.danylo.countriesexplorer.domain.AllCountriesUseCase
import com.orlov.danylo.countriesexplorer.domain.CountryCacheToDomainMapper

interface CountriesProvideUseCase : ProvideUseCase {

    class Base(
        private val provideRepository: ProvideRepository<CountriesRepository>,
        private val error: ProvideUseCase.Error = ProvideUseCase.Error()
    ) : CountriesProvideUseCase {

        @Suppress("UNCHECKED_CAST")
        override fun <T : UseCase> provide(clazz: Class<T>): T = when (clazz) {
            AllCountriesUseCase::class.java -> AllCountriesUseCase.Base(
                provideRepository.provide(),
                CountryCacheToDomainMapper.Base()
            ) as T
            else -> error.provide(clazz)
        }
    }
}
