package com.orlov.danylo.core.data.remote

sealed class NetworkException(message: String) : RuntimeException(message) {
    class NoDataFound(service: String): NetworkException("No data found for service: $service")
    class ServerNotAvailable : NetworkException("Remote service not available.")
}