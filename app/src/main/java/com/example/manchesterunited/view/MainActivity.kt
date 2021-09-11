package com.example.manchesterunited.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.manchesterunited.R
import com.example.manchesterunited.adapter.ViewPagerAdapter
import com.example.manchesterunited.databinding.ActivityMainBinding
import com.example.manchesterunited.fragment.BlankFragment
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.viewmodel.MainViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitInstance.getInstance()

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