package com.example.weatherapp.weathercore

import android.util.Log
import com.example.weatherapp.database.citylist.CityData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class Repository(private val remoteDataSource: RemoteDataSource) {
    suspend fun getCityList(key: String, q: String): Flow<Response<List<CityData>>> {
        val response = remoteDataSource.getResponse(key, q)
        return flow {
            emit(response)
        }.flowOn(Dispatchers.Default)
    }
}