package com.orlov.danylo.countriesexplorer.data.remote

import com.orlov.danylo.countriesexplorer.data.remote.model.CountryApiModel
import retrofit2.Response
import retrofit2.http.GET

interface CountriesService {

    @GET("all")
    suspend fun countries(): Response<List<CountryApiModel.Base>>
}