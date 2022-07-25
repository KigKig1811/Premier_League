package com.example.manchesterunited.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.manchesterunited.R
import com.example.manchesterunited.adapter.ViewPagerAdapter
import com.example.manchesterunited.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       val mViewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = mViewPagerAdapter
          TabLayoutMediator(binding.tabLayout,binding.viewPager, TabLayoutMediator.TabConfigurationStrategy {
              tab, position ->
              when(position){
                  0 -> {tab.text = "Teams"}
                  1 -> {tab.text = "Standing"}
                  2 -> {tab.text = "Top Scorer"}
                  3 ->{tab.text = "Fixtures"}
              }
          }
          ).attach()
    }
}