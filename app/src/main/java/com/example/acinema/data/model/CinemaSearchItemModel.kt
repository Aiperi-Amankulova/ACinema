package com.example.acinema.data.model

import com.google.gson.annotations.SerializedName

data class CinemaSearchItemModel (
    val id : Int = 0,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Year")
    val year: String,
    val imdbID: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Poster", alternate = ["poster"])
    val poster: String,
)