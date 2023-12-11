package com.example.weatherapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weatherapp.constants.Constants.Companion.NA
import com.example.weatherapp.model.forecast.ForecastResult
import com.example.weatherapp.utils.Utils.Companion.buildIcon
import com.example.weatherapp.utils.Utils.Companion.timestampToHumanDate

@Composable
fun ForecastSection(forecastResponse: ForecastResult) {
    return Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        forecastResponse.list?.let { listForeCast ->
            if (listForeCast.size > 0) {
                LazyRow(modifier = Modifier.fillMaxSize()) {
                    items(listForeCast) { currentItem ->
                        currentItem.let { item ->
                            var temp = ""
                            var icon = ""
                            var time = ""
                            item.main.let { main ->
                                temp = if (main == null) NA else "${main.temp} C°"
                            }
                            item.weather.let { weathers ->
                                icon = if (weathers == null) NA else buildIcon(
                                    weathers[0].icon!!,
                                    isBigSize = false
                                )
                            }
                            item.dt.let { dateTime->
                                time = if (dateTime==null) NA
                                else timestampToHumanDate(dateTime.toLong(),"HH:mm")
                            }
                            ForecastTitle()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ForecastTitle() {
    TODO("Not yet implemented")
}
