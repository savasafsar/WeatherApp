package com.example.weatherapp.network

import com.example.weatherapp.constants.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private var apiService :IApiService? = null
        fun getInstance() :IApiService {
            if (apiService==null) {
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(IApiService::class.java)
            }
            return apiService!!
        }
    }
}