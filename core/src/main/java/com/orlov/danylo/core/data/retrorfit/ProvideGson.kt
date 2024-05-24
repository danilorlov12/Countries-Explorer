package com.orlov.danylo.core.data.retrorfit

import com.google.gson.Gson

interface ProvideGson {

    fun provideGson(): Gson

    class Base : ProvideGson {
        override fun provideGson(): Gson = Gson()
    }
}