package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.adapter.MatchAdapter
import com.example.manchesterunited.databinding.FragmentMatchBinding
import com.example.manchesterunited.model.fixtures.Response
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class MatchFragment: Fragment(){

    private val TAG ="MatchFragment"
    private lateinit var binding: FragmentMatchBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = MatchAdapter()
    var matchInfo = mutableListOf<Response>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchBinding.inflate(inflater)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerMatch.adapter = adapter
        viewModel.matchLD.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setMatchList(it)

        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getFixtures()
    }


}