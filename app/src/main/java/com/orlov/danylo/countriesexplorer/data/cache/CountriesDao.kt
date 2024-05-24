package com.orlov.danylo.countriesexplorer.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CountriesDao {

    @Query("SELECT * FROM Countries")
    suspend fun countries(): List<CountryCache.Base>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: CountryCache.Base)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entity: List<CountryCache.Base>)

    @Delete
    suspend fun delete(entity: CountryCache.Base)
}