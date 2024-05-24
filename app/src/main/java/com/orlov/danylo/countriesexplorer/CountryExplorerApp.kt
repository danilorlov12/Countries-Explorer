package com.orlov.danylo.countriesexplorer

import android.app.Application
import com.orlov.danylo.countriesexplorer.sl.CountriesCoreModule
import com.orlov.danylo.countriesexplorer.sl.CountriesDependencyContainer

class CountryExplorerApp : Application(), CountriesCoreModule {

    override fun provideCountiesDependencyContainer(): CountriesDependencyContainer {
        return CountriesCoreModule.Base(this).provideCountiesDependencyContainer()
    }
}