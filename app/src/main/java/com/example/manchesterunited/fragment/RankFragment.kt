package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.manchesterunited.adapter.RankAdapter
import com.example.manchesterunited.databinding.RankFragmnetBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class RankFragment:Fragment() {

    private val TAG = "RankFragment"
    private lateinit var binding: RankFragmnetBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = RankAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = RankFragmnetBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerViewRank.adapter = adapter
        viewModel.standings.observe(viewLifecycleOwner, Observer {
            Log.d(TAG,"onCreate: $it")
            adapter.setRankList(it)
        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getRank()
    }
}