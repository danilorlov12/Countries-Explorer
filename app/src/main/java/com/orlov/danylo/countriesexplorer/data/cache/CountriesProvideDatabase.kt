package com.orlov.danylo.countriesexplorer.data.cache

import android.content.Context
import com.orlov.danylo.core.data.cache.ProvideDatabase

class CountriesProvideDatabase(
    context: Context
) : ProvideDatabase.Abstract(context, "countries.db")