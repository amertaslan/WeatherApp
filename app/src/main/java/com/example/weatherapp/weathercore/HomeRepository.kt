package com.example.weatherapp.weathercore

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class HomeRepository(private val homeRemoteDataSource: HomeRemoteDataSource) {
    suspend fun getCityList(key: String, q: String): Flow<Response<List<CityListResponse>>> {
        val response = homeRemoteDataSource.getCityList(key, q)
        return flow {
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCityCurrentWeather(key: String, q: String): Flow<Response<CityCurrentResponse>> {
        val response = homeRemoteDataSource.getCityCurrentWeather(key, q)
        return flow {
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getCityForecastWeather(key: String, q: String): Flow<Response<CityForecastResponse>> {
        val response = homeRemoteDataSource.getCityForecastWeather(key, q)
        return flow {
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}