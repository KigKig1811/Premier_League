package com.example.manchesterunited.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterTeamBinding
import com.example.manchesterunited.model.Data
import com.example.manchesterunited.model.TeamX
import com.example.manchesterunited.model.Teams

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    var teams = mutableListOf<Teams>()

    /*fun setTeamList(team: List<Teams>){
        this.teams = teams.toMutableList()
        notifyDataSetChanged()
    }*/
    fun setTeamList(teams: List<Teams>){
        this.teams = teams.toMutableList()
        notifyDataSetChanged()
    }
    class MainViewHolder(val binding: AdapterTeamBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeamBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val team = teams[position]
        holder.binding.nameTeam.text = team.name
        Glide.with(holder.itemView.context).load(team.logo).into(holder.binding.logoTeam)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}