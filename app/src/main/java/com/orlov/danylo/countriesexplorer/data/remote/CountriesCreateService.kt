package com.orlov.danylo.countriesexplorer.data.remote

import com.orlov.danylo.core.data.retrorfit.CreateService
import com.orlov.danylo.core.data.retrorfit.ProvideRetrofitBuilder

interface CountriesCreateService : CreateService {

    class Base(
        provide: ProvideRetrofitBuilder
    ) : CreateService.Abstract("https://restcountries.com/v3.1/", provide)
}