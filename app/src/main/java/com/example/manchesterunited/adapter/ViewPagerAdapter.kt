package com.example.manchesterunited.adapter

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.manchesterunited.fragment.*
import com.example.manchesterunited.view.MainActivity

class ViewPagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {

       when(position){
           0 -> return TeamFragment()
           1 -> { return StandingFragment()}
           2 -> return TopScorerFragment()
           3 -> return MatchFragment()

           else -> {
            return TeamFragment()
           }

       }

    }
}