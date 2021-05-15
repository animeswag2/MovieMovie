package com.learn.personal.moviet.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.learn.personal.moviet.R
import com.learn.personal.moviet.data.models.Movie
import com.learn.personal.moviet.databinding.FragmentMoviesBinding
import com.learn.personal.moviet.ui.activity.DetailActivity
import com.learn.personal.moviet.ui.adapters.MovieAdapter
import com.learn.personal.moviet.ui.adapters.OnMovieItemClickCallback
import com.learn.personal.moviet.ui.viewmodel.HomeViewModel

class MoviesFragment : Fragment(R.layout.fragment_movies) {
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var adapter: MovieAdapter

    private var movieList = ArrayList<Movie>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMoviesBinding.bind(view)
        adapter = MovieAdapter(requireActivity(), movieList)
        binding.movieRv.layoutManager = LinearLayoutManager(requireActivity())
        binding.movieRv.adapter = adapter

        initMovies()

        adapter.setOnItemClickCallBack(object: OnMovieItemClickCallback {
            override fun onItemClicked(film: Movie) {
                Log.d("FILM ID", film.id.toString())
                startActivity(
                    Intent(
                        context,
                        DetailActivity::class.java
                    )
                    .putExtra(DetailActivity.TYPE, "Movie")
                    .putExtra(DetailActivity.ID, film.id)
                )
            }
        })
    }

    private fun initMovies() {
        showProgressBar()
        HomeViewModel.getInstance().getListMovies().observe(viewLifecycleOwner, Observer<List<Movie>> { movies ->
            Log.d("Search Result", movies.toString())
            if (movies != null) {
                movieList.clear()
                movieList.addAll(movies)
                adapter.notifyDataSetChanged()
                hideProgressBar()
            }
        })
    }

    private fun hideProgressBar() {
        binding.progressBarMovie.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBarMovie.visibility = View.VISIBLE
    }
}