package com.orlov.danylo.core.sl

interface ProvideRepository<T : Any> {

    fun provide(): T
}
