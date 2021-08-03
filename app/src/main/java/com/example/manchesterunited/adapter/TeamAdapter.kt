package com.example.manchesterunited.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterTeamBinding
import com.example.manchesterunited.model.Team

class TeamAdapter(): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    var teams = mutableListOf<Team>()

    fun setTeamList(team : List<Team>){
        this.teams = teams.toMutableList()
        notifyDataSetChanged()
    }
    class TeamViewHolder(val binding: AdapterTeamBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeamBinding.inflate(inflater,parent,false)

        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val team = teams[position]
        holder.binding.nameTeam.text = team.name
        Glide.with(holder.itemView.context).load(team.logo).into(holder.binding.logoTeam)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}