package com.example.acinema.data.remote

import com.example.acinema.data.model.CinemaSearchModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ImdbService {
    @GET(".")
    fun getCinema(@Query("apiKey") apiKey: String, @Query("s") title: String):
            Call<CinemaSearchModel>
}