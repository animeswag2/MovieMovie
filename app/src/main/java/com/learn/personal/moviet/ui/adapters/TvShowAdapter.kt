package com.learn.personal.moviet.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.personal.moviet.R
import com.learn.personal.moviet.data.api.ApiConfig
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.databinding.SingleItemRowBinding

interface OnTvShowItemClickCallback{
    fun onItemClicked(film: TvShow)
}

class TvShowHolder(
    private val view: View,
    private val context: Context,
    private val callback: OnTvShowItemClickCallback
) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(film: TvShow) {
        val binding = SingleItemRowBinding.bind(view)
        binding.textTitle.text = film.title
        binding.textInfo.text = "First Time Air: ${film.release}"
        Glide.with(context)
                .load(ApiConfig.IMG_URL + film.poster)
                .into(binding.imagePoster)
        binding.container.setOnClickListener {
            callback.onItemClicked(film)
        }
    }
}

class TvShowAdapter(
    private val context: Context,
    private val films: ArrayList<TvShow>,
) : RecyclerView.Adapter<TvShowHolder>() {

    private lateinit var onItemClickCallback: OnTvShowItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnTvShowItemClickCallback){
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.single_item_row, parent, false)
        return TvShowHolder(view, context, onItemClickCallback)
    }

    override fun onBindViewHolder(holder: TvShowHolder, position: Int) = holder.bind(films[position])

    override fun getItemCount(): Int = films.size
}
