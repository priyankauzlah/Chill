package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

data class MovieItemResponse(
    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("title", alternate = ["name"])
    val title: String

)