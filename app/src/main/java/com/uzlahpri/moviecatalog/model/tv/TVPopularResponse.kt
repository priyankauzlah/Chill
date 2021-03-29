package com.uzlahpri.moviecatalog.model.tv

import com.google.gson.annotations.SerializedName

class TVPopularResponse(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val result: ArrayList<TVPopularItemResponse>
)