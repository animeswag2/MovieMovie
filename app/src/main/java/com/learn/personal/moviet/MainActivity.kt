package com.learn.personal.moviet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.learn.personal.moviet.databinding.ActivityMainBinding
import com.learn.personal.moviet.ui.adapters.ViewPagerAdapter
import com.learn.personal.moviet.ui.fragments.MoviesFragment
import com.learn.personal.moviet.ui.fragments.TvShowsFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val viewPagerAdapter = ViewPagerAdapter(
            arrayListOf<Fragment>(
                MoviesFragment(),
                TvShowsFragment()
            ),
            supportFragmentManager,
            lifecycle
        )
        binding.viewPager.adapter = viewPagerAdapter

        binding.tabNav.addTab(binding.tabNav.newTab().setText("Movies").setId(R.id.tabNavMovie))
        binding.tabNav.addTab(binding.tabNav.newTab().setText("TV Shows").setId(R.id.tabNavTvShow))

        binding.tabNav.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.currentItem = tab!!.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tabNav.selectTab(binding.tabNav.getTabAt(position))
                super.onPageSelected(position)
            }
        })
    }
}