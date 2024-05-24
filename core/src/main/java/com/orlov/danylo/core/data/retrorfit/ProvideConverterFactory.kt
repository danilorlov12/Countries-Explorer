package com.orlov.danylo.core.data.retrorfit

import retrofit2.Converter
import retrofit2.converter.gson.GsonConverterFactory

interface ProvideConverterFactory {

    fun provideConverterFactory(): Converter.Factory

    class Gson(
        private val provideGson: com.google.gson.Gson
    ) : ProvideConverterFactory {

        override fun provideConverterFactory(): Converter.Factory =
            GsonConverterFactory.create(provideGson)
    }
}
