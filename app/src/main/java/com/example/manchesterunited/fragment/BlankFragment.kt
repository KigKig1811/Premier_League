package com.example.manchesterunited.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.manchesterunited.R
import com.google.android.material.tabs.TabLayout





class BlankFragment : Fragment() {
     val TAG = BlankFragment ::class.simpleName



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                val teamFragment: TeamFragment = TeamFragment()
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }


}