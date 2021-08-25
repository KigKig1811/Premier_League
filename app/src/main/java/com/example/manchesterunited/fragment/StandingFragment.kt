package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.adapter.StandingAdapter
import com.example.manchesterunited.databinding.StandingFragmentBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.service.Retrofit_Instance_Standing
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class StandingFragment: Fragment() {
    private val TAG ="StandingFragment"
    private lateinit var binding: StandingFragmentBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = Retrofit_Instance_Standing.getInstance_Standing()
    val adapter = StandingAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StandingFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =

            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recycStading.adapter = adapter
        viewModel.standings.observe(viewLifecycleOwner,{
            Log.d(TAG, "onCreate: $it")
            adapter.setStandingList(it)
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getStanding()
    }

}