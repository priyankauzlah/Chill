package com.uzlahpri.moviecatalog.network

import android.telecom.Call
import com.uzlahpri.moviecatalog.model.PopularResponse
import com.uzlahpri.moviecatalog.model.UpcomingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET ("/movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<PopularResponse>

    @GET ("/movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<UpcomingResponse>
}