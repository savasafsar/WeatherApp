package com.example.weatherapp.constants

class Constants {
    companion object {
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
        const val openWeatherMapApiKey = "b732e0671e02ce1074950b4ba1b388d5"
        const val colorBg1 = 0xff08203e
        const val colorBg2 = 0xff557c93

        const val LOADING = "Loading..."
        const val NA = "N/A"

    }
}