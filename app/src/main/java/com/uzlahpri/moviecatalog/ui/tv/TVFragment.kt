package com.uzlahpri.moviecatalog.ui.tv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.uzlahpri.moviecatalog.R
import com.uzlahpri.moviecatalog.adapter.PopularTVAdapter
import com.uzlahpri.moviecatalog.model.tv.TVPopularItemResponse
import kotlinx.android.synthetic.main.fragment_movie.*
import kotlinx.android.synthetic.main.fragment_tv.*
import kotlinx.android.synthetic.main.fragment_tv.rv_tv_popular
import kotlinx.android.synthetic.main.fragment_tv.view.*

class TVFragment : Fragment() {
    private lateinit var tvViewModel: TVViewModel
    private lateinit var popularTvAdapter: PopularTVAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_tv, container, false)
        tvViewModel = ViewModelProvider(this).get(TVViewModel::class.java)
        tvViewModel.initPopularTV(1)
        tvViewModel.getTvPopularData()
            .observe(viewLifecycleOwner, { tvPopular -> getInitTvPopular(tvPopular) })
        return root
    }

    private fun getInitTvPopular(tvPopular : List<TVPopularItemResponse>){
        rv_tv_popular.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
            popularTvAdapter= PopularTVAdapter(tvPopular)
            rv_tv_popular.adapter = popularTvAdapter
        }
    }
}