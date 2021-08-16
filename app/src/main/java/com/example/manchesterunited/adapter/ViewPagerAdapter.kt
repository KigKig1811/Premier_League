package com.example.manchesterunited.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.manchesterunited.fragment.BlankFragment
import com.example.manchesterunited.fragment.MatchFragment
import com.example.manchesterunited.fragment.TeamFragment
import com.example.manchesterunited.view.MainActivity

class ViewPagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {

       when(position){
           0 -> return TeamFragment()
           1 -> {
               Log.d("A",MatchFragment::class.simpleName.toString())
               return MatchFragment()}
           2 -> return BlankFragment()
           else -> {
            return TeamFragment()
           }

       }

    }
}