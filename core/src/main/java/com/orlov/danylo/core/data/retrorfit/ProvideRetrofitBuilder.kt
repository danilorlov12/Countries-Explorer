package com.orlov.danylo.core.data.retrorfit

import retrofit2.Retrofit

interface ProvideRetrofitBuilder {

    fun provideRetrofitBuilder(): Retrofit.Builder

    class Base(
        private val provideOkHttp: ProvideOkHttpClientBuilder,
        private val provideFactory: ProvideConverterFactory
    ) : ProvideRetrofitBuilder {

        override fun provideRetrofitBuilder(): Retrofit.Builder {
            return Retrofit.Builder()
                .client(provideOkHttp.provideClientBuilder().build())
                .addConverterFactory(provideFactory.provideConverterFactory())
        }
    }
}
