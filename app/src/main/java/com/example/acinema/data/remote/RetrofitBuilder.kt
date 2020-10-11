package com.example.acinema.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private var service:  ImdbService? = null
    fun getService(): ImdbService? {
        if (service == null ) service = buildRetrofit()

        return service
    }

    private fun buildRetrofit(): ImdbService {
        return Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ImdbService::class.java)
    }
}
