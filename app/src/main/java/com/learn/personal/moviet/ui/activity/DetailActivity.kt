package com.learn.personal.moviet.ui.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.learn.personal.moviet.data.api.ApiConfig
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.databinding.ActivityDetailBinding
import com.learn.personal.moviet.ui.viewmodel.HomeViewModel

class DetailActivity : AppCompatActivity() {
    companion object {
        const val TYPE = "type"
        const val ID = "id"
    }

    private lateinit var binding: ActivityDetailBinding

    private lateinit var film: LiveData<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initDetail()

        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    private fun initDetail() {
        val id: Int = intent.getIntExtra(ID, 0)

        showProgressBar()
        when (intent.getStringExtra(TYPE)) {
            "Movie" ->
                HomeViewModel.getInstance().getMovieById(id).observe(this, Observer<Movie> { film ->
                    if (film != null) {
                        displayDetailMovie(film)
                        hideProgressBar()
                    }
                })
            "TvShow" ->
                HomeViewModel.getInstance().getTvShowById(id).observe(this, Observer<TvShow> { film ->
                    if (film != null) {
                        displayDetailTvShow(film)
                        hideProgressBar()
                    }
            })
        }
    }

    private fun displayDetailMovie(film: Movie) {
        Glide.with(applicationContext)
            .load(ApiConfig.IMG_URL + film.poster)
            .into(binding.imageView)

        binding.detailTextTitle.text = film.title
        binding.detailTextInfo.text = film.release
        binding.detailTextDescription.text = film.overview
        binding.ratingBarDetail.rating = film.vote / 2

        supportActionBar!!.title = film.title
    }

    private fun displayDetailTvShow(film: TvShow) {
        Glide.with(applicationContext)
            .load(ApiConfig.IMG_URL + film.poster)
            .into(binding.imageView)

        binding.detailTextTitle.text = film.title
        binding.detailTextInfo.text = film.release
        binding.detailTextDescription.text = film.overview
        binding.ratingBarDetail.rating = film.vote / 2

        supportActionBar!!.title = film.title
    }

    private fun hideProgressBar() {
        binding.progressBarDetail.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBarDetail.visibility = View.VISIBLE
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}
