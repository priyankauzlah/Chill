package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

class TVPopularItemResponse(
    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("first_air_date")
    val first_air_date: String
)