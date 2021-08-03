package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.manchesterunited.adapter.TeamAdapter
import com.example.manchesterunited.databinding.FragmentTeamBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.service.Retrofit_Service
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class TeamFragment: Fragment() {
    private val TAG = "TeamFragment"
    private lateinit var binding: FragmentTeamBinding
    lateinit var viewModel: MainViewModel

    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = TeamAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this,ViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java
        )

        binding.recycTeam.adapter = adapter


        viewModel.teamList.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setTeamList(it)
        })


        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getAllTeam()


    }

}