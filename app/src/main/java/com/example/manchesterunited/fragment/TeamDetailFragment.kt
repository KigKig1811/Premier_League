package com.example.manchesterunited.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.R
import com.example.manchesterunited.adapter.PlayerOfTeamAdapter
import com.example.manchesterunited.databinding.TeamDetailsFragmentBinding
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory
import com.google.android.material.tabs.TabLayout

class TeamDetailFragment: Fragment() {
    private val TAG ="TeamDetailFragment"
    private lateinit var binding: TeamDetailsFragmentBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = PlayerOfTeamAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TeamDetailsFragmentBinding.inflate(inflater)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
                MainViewModel::class.java
            )
        binding.recycPlayer.adapter = adapter
        viewModel.players.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setPlayerList(it)

        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {
        })
        viewModel.getAllPlayerofTeam()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val tabLayout: TabLayout
                if (isEnabled){
                    tabLayout = requireActivity().findViewById(R.id.tabLayout)
                    tabLayout.visibility = View.VISIBLE
                    requireActivity().supportFragmentManager.popBackStack()

                }else{
                    isEnabled = false
                    activity?.onBackPressed()
                }

            }

        })
    }
}