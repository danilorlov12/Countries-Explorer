package com.orlov.danylo.core.data.remote

import retrofit2.Response

abstract class AbstractRemoteDataSource(
    private val service: String = ""
) {

    protected suspend fun <T: Any> handle(block: suspend () -> Response<T>): T {
        try {
            val response = block.invoke()
            when (response.code()) {
                404 -> throw NetworkException.NoDataFound(service)
                in 500..599 -> throw NetworkException.ServerNotAvailable()
            }
            return response.body()!!
        } catch (e: Exception) {
            throw e
        }
    }
}