package com.orlov.danylo.countriesexplorer.presentation

import com.orlov.danylo.core.presentation.Communication
import com.orlov.danylo.countriesexplorer.domain.Country

interface CountryCommunication : Communication {

    interface Update : Communication.Update<List<Country>>

    interface Observe : Communication.Observe<List<Country>>

    interface Mutable : Communication.Mutable<List<Country>>

    class Base : Communication.AbstractLiveData<List<Country>>(), Observe, Update, Mutable
}
