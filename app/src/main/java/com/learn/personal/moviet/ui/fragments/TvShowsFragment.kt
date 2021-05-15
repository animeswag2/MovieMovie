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
import com.learn.personal.moviet.data.models.TvShow
import com.learn.personal.moviet.databinding.FragmentTvShowsBinding
import com.learn.personal.moviet.ui.activity.DetailActivity
import com.learn.personal.moviet.ui.adapters.OnTvShowItemClickCallback
import com.learn.personal.moviet.ui.adapters.TvShowAdapter
import com.learn.personal.moviet.ui.viewmodel.HomeViewModel

class TvShowsFragment : Fragment(R.layout.fragment_tv_shows) {
    private lateinit var binding: FragmentTvShowsBinding
    private lateinit var adapter: TvShowAdapter

    private var tvShowList = ArrayList<TvShow>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTvShowsBinding.bind(view)
        adapter = TvShowAdapter(requireActivity(), tvShowList)
        binding.tvShowRv.layoutManager = LinearLayoutManager(requireActivity())
        binding.tvShowRv.adapter = adapter

        initTvShows()

        adapter.setOnItemClickCallBack(object: OnTvShowItemClickCallback {
            override fun onItemClicked(film: TvShow) {
                startActivity(
                    Intent(
                        context,
                        DetailActivity::class.java
                    )
                    .putExtra(DetailActivity.TYPE, "TvShow")
                    .putExtra(DetailActivity.ID, film.id)
                )
            }
        })
    }

    private fun initTvShows() {
        showProgressBar()
        HomeViewModel.getInstance().getListTvShows().observe(viewLifecycleOwner, Observer<List<TvShow>> { tvShows ->
            Log.d("Search Result", tvShows.toString())
            if (tvShows != null) {
                tvShowList.clear()
                tvShowList.addAll(tvShows)
                adapter.notifyDataSetChanged()
                hideProgressBar()
            }
        })
    }

    private fun hideProgressBar() {
        binding.progressBarTvShow.visibility = View.INVISIBLE
    }

    private fun showProgressBar() {
        binding.progressBarTvShow.visibility = View.VISIBLE
    }
}