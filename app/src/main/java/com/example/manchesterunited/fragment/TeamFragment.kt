package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.adapter.TeamAdapter
import com.example.manchesterunited.databinding.TeamFragmentBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.service.Retrofit_Service
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory
import retrofit2.http.Tag

class TeamFragment: Fragment() {

    private val TAG ="TeamFragment"
    private lateinit var binding: TeamFragmentBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = TeamAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TeamFragmentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recyclerViewTeam.adapter = adapter
        viewModel.teams.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setTeamList(it)

        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getAllTeam()
    }
}