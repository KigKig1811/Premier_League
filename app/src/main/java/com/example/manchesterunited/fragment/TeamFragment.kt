package com.example.manchesterunited.fragment

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.manchesterunited.R
import com.example.manchesterunited.`interface`.BackPressHandler
import com.example.manchesterunited.adapter.TeamAdapter
import com.example.manchesterunited.databinding.ActivityMainBinding
import com.example.manchesterunited.databinding.TeamFragmentBinding
import com.example.manchesterunited.model.Teams
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.service.RetrofitInstance
import com.example.manchesterunited.view.MainActivity
import com.example.manchesterunited.viewmodel.MainViewModel
import com.example.manchesterunited.viewmodel.ViewModelFactory
import com.google.android.material.tabs.TabLayout

class TeamFragment: Fragment(),TeamAdapter.OnItemClick {

    private val TAG ="TeamFragment"
    private lateinit var binding: TeamFragmentBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitInstance.getInstance()
    val adapter = TeamAdapter(this)
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

    override fun OnItemClick(item: Teams, position: Int) {

        val tabLayout : TabLayout
        tabLayout = requireActivity().findViewById(R.id.tabLayout)
        tabLayout.visibility = View.GONE
        if (position == 0) {
            val fragment: Fragment = Fragment()
            val blankFragment: BlankFragment = BlankFragment()
            val teamFragment: TeamFragment = TeamFragment()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frameLayout,blankFragment)
                .addToBackStack(BlankFragment::TAG.toString())
                .commit()

        }else if(position == 1){
            Toast.makeText(activity,item.name, Toast.LENGTH_LONG).show()
        }
    }



    /*override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this,object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                val teamFragment: TeamFragment = TeamFragment()
                val tabLayout : TabLayout
                tabLayout = requireActivity().findViewById(R.id.tabLayout)
                tabLayout.visibility = View.VISIBLE
                requireActivity().supportFragmentManager.beginTransaction()
                    .replace(R.id.frameLayout,teamFragment)
                    .addToBackStack(null)
                    .commit()
            }

        })
    }*/


}