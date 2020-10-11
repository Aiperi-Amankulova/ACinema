package com.example.acinema.data.model

import com.google.gson.annotations.SerializedName

data class CinemaSearchModel(
    val totalResults: String,
    @SerializedName("Response")
    val response : String,
    @SerializedName("Search")
    val search : List<CinemaSearchItemModel>

)