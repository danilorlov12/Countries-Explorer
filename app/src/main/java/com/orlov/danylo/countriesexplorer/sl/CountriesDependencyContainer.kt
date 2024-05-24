package com.orlov.danylo.countriesexplorer.sl

import androidx.lifecycle.ViewModel
import com.orlov.danylo.core.presentation.DispatcherCall
import com.orlov.danylo.core.sl.DependencyContainer
import com.orlov.danylo.core.sl.Module
import com.orlov.danylo.countriesexplorer.domain.AllCountriesUseCase
import com.orlov.danylo.countriesexplorer.presentation.CountryViewModel

interface CountriesDependencyContainer : DependencyContainer {

    class Base(
        private val dispatcherCall: DispatcherCall,
        private val provideUseCase: CountriesProvideUseCase,
        private val error: DependencyContainer = DependencyContainer.Error()
    ) : CountriesDependencyContainer {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> module(clazz: Class<T>): Module<T> = when (clazz) {
            CountryViewModel::class.java -> CountryModule(
                dispatcherCall,
                provideUseCase.provide(AllCountriesUseCase::class.java)
            ) as Module<T>
            else -> error.module(clazz)
        }
    }
}
