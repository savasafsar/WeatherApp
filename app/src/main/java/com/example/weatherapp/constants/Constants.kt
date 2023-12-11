package com.example.weatherapp.constants

class Constants {
    companion object {
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        const val openWeatherMapApiKey = "a3d4799805c9498e05474a9547d15ae4"
        const val colorBg1 = 0xff08203e
        const val colorBg2 = 0xff557c93

        const val LOADING = "Loading..."
        const val NA = "N/A"
        const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    }
}