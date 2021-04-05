package com.uzlahpri.moviecatalog.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.uzlahpri.moviecatalog.BuildConfig
import com.uzlahpri.moviecatalog.R
import com.uzlahpri.moviecatalog.model.tv.TVTopItemResponse
import kotlinx.android.synthetic.main.item_popular_movie.view.*
import kotlinx.android.synthetic.main.item_tv_top_rated.view.*

class TopTVAdapter(var listTVTop: List<TVTopItemResponse>) :
    RecyclerView.Adapter<TopTVAdapter.TVViewHolder>() {

    inner class TVViewHolder (val view: View) : RecyclerView.ViewHolder(view){
        fun bind(tvtop: TVTopItemResponse) {
            with(itemView) {
                Glide.with(context)
                    .load(BuildConfig.IMAGE_URL + tvtop.poster_path)
                    .into(iv_tv_top_poster)
                tv_title_top_tv.text = tvtop.name
                tv_desc_top.text = tvtop.overview
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        return TVViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_tv_top_rated, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        holder.bind(listTVTop.get(position))
    }

    override fun getItemCount(): Int = listTVTop.size


}