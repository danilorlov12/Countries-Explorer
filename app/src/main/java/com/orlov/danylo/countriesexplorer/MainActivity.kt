package com.orlov.danylo.countriesexplorer

import android.os.Bundle
import com.orlov.danylo.core.presentation.AbstractFragmentActivity
import com.orlov.danylo.countriesexplorer.presentation.CountryFragment

class MainActivity : AbstractFragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        openFragment(CountryFragment())
    }
}