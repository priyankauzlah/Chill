package com.uzlahpri.moviecatalog.ui.tv

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uzlahpri.moviecatalog.BuildConfig
import com.uzlahpri.moviecatalog.model.movie.PopularResponse
import com.uzlahpri.moviecatalog.model.tv.TVPopularItemResponse
import com.uzlahpri.moviecatalog.model.tv.TVPopularResponse
import com.uzlahpri.moviecatalog.network.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TVViewModel : ViewModel() {

    fun initPopularTV(page: Int) {
        getPopularTV(page)
    }
    private val dataPopularTv = MutableLiveData<List<TVPopularItemResponse>>()
    private fun getPopularTV(page: Int) {
        RetrofitConfig().getApiService().getTVPopular(BuildConfig.API_KEY, page)
            .enqueue(object : Callback<TVPopularResponse>{
                override fun onResponse(
                    call: Call<TVPopularResponse>,
                    response: Response<TVPopularResponse>
                ) {
                    if (response.isSuccessful){
                        val responseTVPopular : TVPopularResponse? = response.body()
                        dataPopularTv.postValue(responseTVPopular?.result)
                    }
                }

                override fun onFailure(call: Call<TVPopularResponse>, t: Throwable) {
                    Log.e("failure", t.toString())
                }
            })
    }

    fun getTvPopularData() : LiveData<List<TVPopularItemResponse>>{
        return dataPopularTv
    }

}
