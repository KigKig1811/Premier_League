package com.example.manchesterunited.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.manchesterunited.fragment.BlankFragment
import com.example.manchesterunited.fragment.MatchFragment
import com.example.manchesterunited.fragment.RankFragment
import com.example.manchesterunited.fragment.TeamFragment
import com.example.manchesterunited.view.MainActivity

class ViewPagerAdapter(fragment: MainActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
       return 4
    }

    override fun createFragment(position: Int): Fragment {

       when(position){
           0 -> return TeamFragment()
           1 -> return RankFragment()
           2 -> return MatchFragment()
           3 -> return BlankFragment()
           else -> {
            return TeamFragment()
           }

       }

    }
}