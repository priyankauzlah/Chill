package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

class TVPopularItemResponse(
    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("name", alternate = ["name"])
    val name: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("original_language")
    val original_language: String
)