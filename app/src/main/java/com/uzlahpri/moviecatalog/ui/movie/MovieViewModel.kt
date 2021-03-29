package com.uzlahpri.moviecatalog.ui.movie

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uzlahpri.moviecatalog.BuildConfig
import com.uzlahpri.moviecatalog.model.movie.MovieUpcomingItemResponse
import com.uzlahpri.moviecatalog.model.movie.PopularResponse
import com.uzlahpri.moviecatalog.model.movie.UpcomingResponse
import com.uzlahpri.moviecatalog.model.tv.MovieItemResponse
import com.uzlahpri.moviecatalog.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {
    fun init(page: Int) {
        getPopularMovie(page)
    }

    //data
    private val data = MutableLiveData<List<MovieItemResponse>>()

    private fun getPopularMovie(page: Int) {
        RetrofitConfig().getApiService().getPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<PopularResponse> {
                override fun onResponse(
                    call: Call<PopularResponse>,
                    response: Response<PopularResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseMovie: PopularResponse? = response.body()
                        data.postValue(responseMovie?.result)
                    }
                }

                override fun onFailure(call: Call<PopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }

            })
    }

    //get all atribut dari popular movie
    fun getData(): LiveData<List<MovieItemResponse>> {
        return data
    }

//    =========== punya upcoming ============
    //call page
    fun initUp(page: Int) {
        getUpcoming(page)
    }

    private val dataUpcoming = MutableLiveData<List<UpcomingResponse>>()

    private fun getUpcoming(page: Int) {
        RetrofitConfig().getApiService().getUpcoming(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<MovieUpcomingItemResponse> {
                override fun onResponse(
                    call: Call<MovieUpcomingItemResponse>,
                    response: Response<MovieUpcomingItemResponse>
                ) {
                    if (response.isSuccessful) {
                        val upcomingResponse: MovieUpcomingItemResponse? = response.body()
                        dataUpcoming.postValue(upcomingResponse?.result)
                    }
                }

                override fun onFailure(call: Call<MovieUpcomingItemResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }

            })
    }
    fun getDataUpcoming(): LiveData<List<UpcomingResponse>>{
        return dataUpcoming
    }
}