package com.example.manchesterunited.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.R
import com.example.manchesterunited.adapter.MainAdapter
import com.example.manchesterunited.databinding.ActivityMainBinding

import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.rec1.adapter = adapter
        viewModel.teams.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setTeamList(it)

        })

        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllTeam()
    }
}