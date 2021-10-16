package com.example.weatherapp.weathercore

import com.example.weatherapp.database.citylist.CityData
import kotlinx.coroutines.flow.map
import retrofit2.Response
import kotlinx.coroutines.flow.Flow

class UseCase(private val repository: Repository) {
    suspend fun getCityList(key: String, q: String) : Flow<Response<List<CityData>>> {
        return repository.getCityList(key, q).map { response ->
            response
        }
    }
}