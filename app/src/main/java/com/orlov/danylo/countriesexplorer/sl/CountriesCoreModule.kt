package com.orlov.danylo.countriesexplorer.sl

import android.content.Context
import com.orlov.danylo.core.data.retrorfit.ProvideConverterFactory
import com.orlov.danylo.core.data.retrorfit.ProvideGson
import com.orlov.danylo.core.data.retrorfit.ProvideOkHttpClientBuilder
import com.orlov.danylo.core.data.retrorfit.ProvideRetrofitBuilder
import com.orlov.danylo.core.presentation.DispatcherCall
import com.orlov.danylo.countriesexplorer.data.cache.CountriesDatabase
import com.orlov.danylo.countriesexplorer.data.cache.CountriesProvideDatabase
import com.orlov.danylo.countriesexplorer.data.remote.CountriesCreateService
import okhttp3.logging.HttpLoggingInterceptor

interface CountriesCoreModule {

    fun provideCountiesDependencyContainer(): CountriesDependencyContainer

    class Base(context: Context) : CountriesCoreModule {

        private val countriesDatabase by lazy {
            CountriesProvideDatabase(context).provide(CountriesDatabase::class.java)
        }
        private val loggingInterceptor by lazy {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
        private val createService by lazy {
            CountriesCreateService.Base(
                ProvideRetrofitBuilder.Base(
                    ProvideOkHttpClientBuilder.Base(),
                    ProvideConverterFactory.Gson(ProvideGson.Base().provideGson())
                )
            )
        }
        private val provideDao by lazy {
            ProvideDao.Base(countriesDatabase)
        }
        private val provideRepository by lazy {
            ProvideCountriesRepository.Base(
                provideDao,
                createService
            )
        }
        private val provideUseCase by lazy {
            CountriesProvideUseCase.Base(provideRepository)
        }

        private val dispatcherCall: DispatcherCall = DispatcherCall.Base()

        override fun provideCountiesDependencyContainer(): CountriesDependencyContainer {
            return CountriesDependencyContainer.Base(
                dispatcherCall,
                provideUseCase
            )
        }
    }
}
