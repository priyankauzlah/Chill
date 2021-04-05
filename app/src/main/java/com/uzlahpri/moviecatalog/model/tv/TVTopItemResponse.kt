package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

class TVTopItemResponse (
    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("overview")
    val overview: String
)