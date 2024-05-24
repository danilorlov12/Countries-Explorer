package com.orlov.danylo.countriesexplorer.sl

import com.orlov.danylo.countriesexplorer.data.cache.CountriesDao
import com.orlov.danylo.countriesexplorer.data.cache.CountriesDatabase

interface ProvideDao {

    fun <T : Any> provide(clazz: Class<T>): T

    class Base(
        private val provideDatabase: CountriesDatabase,
        private val error: Error = Error()
    ) : ProvideDao {

        @Suppress("UNCHECKED_CAST")
        override fun <T : Any> provide(clazz: Class<T>): T = when (clazz) {
            CountriesDao::class.java -> provideDatabase.countriesDao() as T
            else -> error.provide(clazz)
        }
    }

    class Error : ProvideDao {
        override fun <T : Any> provide(clazz: Class<T>): T =
            throw IllegalStateException("There is not dao for class $clazz")
    }
}
