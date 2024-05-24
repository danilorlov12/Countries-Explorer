package com.orlov.danylo.core.data

interface DataSource<T: Any> {
    suspend fun data(): T
}