package com.uzlahpri.moviecatalog.model.movie

import com.google.gson.annotations.SerializedName

class MovieUpcomingItemResponse (
    @SerializedName("page")
    val page : Int,

    @SerializedName("results")
    val result : ArrayList<UpcomingResponse>
    )