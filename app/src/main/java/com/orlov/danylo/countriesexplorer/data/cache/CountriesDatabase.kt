package com.orlov.danylo.countriesexplorer.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CountryCache.Base::class],
    version = 1,
    exportSchema = true
)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountriesDao
}