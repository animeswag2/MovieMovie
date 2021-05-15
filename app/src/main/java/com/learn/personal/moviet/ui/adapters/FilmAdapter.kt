package com.learn.personal.moviet.ui.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.learn.personal.moviet.R
import com.learn.personal.moviet.databinding.SingleItemRowBinding
import com.learn.personal.moviet.models.Film

interface OnItemClickCallback{
    fun onItemClicked(film: Film)
}

class FilmHolder(
    private val view: View,
    private val context: Context,
    private val callback: OnItemClickCallback
) : RecyclerView.ViewHolder(view) {
    @SuppressLint("SetTextI18n")
    fun bind(film: Film) {
        val binding = SingleItemRowBinding.bind(view)
        binding.textTitle.text = film.title
        binding.textInfo.text = "Time: ${film.info}"
        Glide.with(context)
                .load(film.poster)
                .into(binding.imagePoster)
        binding.container.setOnClickListener {
            callback.onItemClicked(film)
        }
    }
}

class FilmAdapter(
    private val context: Context,
    private val films: ArrayList<Film>,
) : RecyclerView.Adapter<FilmHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.single_item_row, parent, false)
        return FilmHolder(view, context, onItemClickCallback)
    }

    override fun onBindViewHolder(holder: FilmHolder, position: Int) = holder.bind(films[position])

    override fun getItemCount(): Int = films.size
}
