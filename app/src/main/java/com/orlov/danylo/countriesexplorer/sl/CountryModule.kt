package com.orlov.danylo.countriesexplorer.sl

import com.orlov.danylo.core.presentation.DispatcherCall
import com.orlov.danylo.core.sl.Module
import com.orlov.danylo.countriesexplorer.domain.AllCountriesUseCase
import com.orlov.danylo.countriesexplorer.presentation.CountryCommunication
import com.orlov.danylo.countriesexplorer.presentation.CountryViewModel

class CountryModule(
    private val dispatchers: DispatcherCall,
    private val useCase: AllCountriesUseCase
) : Module<CountryViewModel> {

    override fun viewModel(): CountryViewModel {
        return CountryViewModel(dispatchers, useCase, CountryCommunication.Base())
    }
}
