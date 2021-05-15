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
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.databinding.SingleItemRowBinding

interface OnMovieItemClickCallback{
    fun onItemClicked(film: Movie)
}

class MovieHolder(
    private val view: View,
    private val context: Context,
    private val callback: OnMovieItemClickCallback
) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(film: Movie) {
        val binding = SingleItemRowBinding.bind(view)
        binding.textTitle.text = film.title
        binding.textInfo.text = "Release: ${film.release}"
        Glide.with(context)
                .load(ApiConfig.IMG_URL + film.poster)
                .into(binding.imagePoster)
        binding.container.setOnClickListener {
            callback.onItemClicked(film)
        }
    }
}

class MovieAdapter(
    private val context: Context,
    private val films: ArrayList<Movie>,
) : RecyclerView.Adapter<MovieHolder>() {

    private lateinit var onItemClickCallback: OnMovieItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnMovieItemClickCallback){
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.single_item_row, parent, false)
        return MovieHolder(view, context, onItemClickCallback)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) = holder.bind(films[position])

    override fun getItemCount(): Int = films.size
}
