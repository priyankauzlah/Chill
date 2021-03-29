package com.uzlahpri.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uzlahpri.moviecatalog.BuildConfig
import com.uzlahpri.moviecatalog.R
import com.uzlahpri.moviecatalog.model.tv.TVPopularItemResponse
import kotlinx.android.synthetic.main.item_tv_popular.view.*

class PopularTVAdapter(var listTvPopular: List<TVPopularItemResponse>) :
    RecyclerView.Adapter<PopularTVAdapter.TvPopularViewHolder>() {

    class TvPopularViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(tvpopular: TVPopularItemResponse) {
            with(itemView) {
                Glide.with(context).load(BuildConfig.IMAGE_URL + tvpopular.poster_path)
                    .into(iv_tv_popular)
                tv_title_tv_popular.text = tvpopular.name
                tv_language_tv_popular.text = tvpopular.original_language
            }
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularTVAdapter.TvPopularViewHolder {
        return TvPopularViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tv_popular, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PopularTVAdapter.TvPopularViewHolder, position: Int) {
        holder.bind(listTvPopular.get(position))
    }

    override fun getItemCount(): Int = listTvPopular.size

}