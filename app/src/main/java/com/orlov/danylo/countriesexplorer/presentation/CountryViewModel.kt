package com.orlov.danylo.countriesexplorer.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.orlov.danylo.core.presentation.DispatcherCall
import com.orlov.danylo.countriesexplorer.domain.AllCountriesUseCase
import com.orlov.danylo.countriesexplorer.domain.Country

class CountryViewModel(
    dispatchers: DispatcherCall,
    private val countryUseCase: AllCountriesUseCase,
    private val countryCommunication: CountryCommunication.Mutable
) : ViewModel(), CountryCommunication.Observe {

    init {
        dispatchers.io(viewModelScope) {
            val country = countryUseCase.countries()
            dispatchers.switchUi {
                countryCommunication.update(country)
            }
        }
    }

    override fun observe(lifecycleOwner: LifecycleOwner, observer: Observer<List<Country>>) {
        countryCommunication.observe(lifecycleOwner, observer)
    }
}
