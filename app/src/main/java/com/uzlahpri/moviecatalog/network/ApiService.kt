package com.uzlahpri.moviecatalog.network

import com.uzlahpri.moviecatalog.model.movie.MovieUpcomingItemResponse
import com.uzlahpri.moviecatalog.model.movie.PopularResponse
import com.uzlahpri.moviecatalog.model.movie.UpcomingResponse
import com.uzlahpri.moviecatalog.model.tv.TVPopularItemResponse
import com.uzlahpri.moviecatalog.model.tv.TVPopularResponse
import com.uzlahpri.moviecatalog.model.tv.TVTopResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET ("movie/popular")
    fun getPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<PopularResponse>

    @GET ("movie/upcoming")
    fun getUpcoming(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<MovieUpcomingItemResponse>

    @GET ("tv/popular")
    fun getTVPopular(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<TVPopularResponse>

    @GET ("tv/top_rated")
    fun getTVTop(
        @Query("api_key") apiKey: String,
        @Query("page") page : Int
    ): retrofit2.Call<TVTopResponse>
}