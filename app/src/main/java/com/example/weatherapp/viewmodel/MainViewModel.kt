package com.example.weatherapp.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.MyLatLng
import com.example.weatherapp.model.forecast.ForecastResult
import com.example.weatherapp.model.weather.Weather
import com.example.weatherapp.model.weather.WeatherResult
import com.example.weatherapp.network.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.Retrofit

enum class STATE {
    LOADING,
    SUCCESS,
    FAILED
}
class MainViewModel : ViewModel() {
    var state by mutableStateOf(STATE.LOADING)
    var weatherResponse: WeatherResult by mutableStateOf(WeatherResult())
    var forecastResponse: ForecastResult by mutableStateOf(ForecastResult())
    var errorMessage: String by mutableStateOf("")

    fun getWeatherByLocation(latLng: MyLatLng) {

        viewModelScope.launch {
            try {
                val apiService = RetrofitClient.getInstance()
                val apiResponse = apiService.getWeather(latLng.lat, latLng.lng)
                weatherResponse = apiResponse
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message ?: "Unknown error"
                state = STATE.FAILED
            }
        }
    }

    fun getForecastByLocation(latLng: MyLatLng) {
        viewModelScope.launch {
            try {
                val apiService = RetrofitClient.getInstance()
                val apiResponse = apiService.getForecast(latLng.lat, latLng.lng)
                forecastResponse = apiResponse
                state = STATE.SUCCESS
            } catch (e: Exception) {
                errorMessage = e.message ?: "Unknown error"
                state = STATE.FAILED
            }
        }
    }
}