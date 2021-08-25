package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.adapter.TopScorer_Adapter
import com.example.manchesterunited.databinding.FragmentTopscorerBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.Retrofit_Instance_TopScorer
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory

class TopScorerFragment :Fragment(){
    private val TAG ="TopScorerFragment"
    private lateinit var binding: FragmentTopscorerBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = Retrofit_Instance_TopScorer.getInstance_TopScorer()
    val adapter = TopScorer_Adapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTopscorerBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recycletViewTopScorer.adapter = adapter
        viewModel.playerTopScorers.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setTopScorerList(it)

        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getTopScorer()
    }

}