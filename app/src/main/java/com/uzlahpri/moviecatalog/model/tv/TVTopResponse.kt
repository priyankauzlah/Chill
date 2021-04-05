package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

class TVTopResponse(
    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: ArrayList<TVTopItemResponse>
)