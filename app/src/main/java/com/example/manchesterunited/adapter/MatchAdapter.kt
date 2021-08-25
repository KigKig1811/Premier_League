package com.example.manchesterunited.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterMatchBinding
import com.example.manchesterunited.model.Teams
import com.example.manchesterunited.model.fixtures.Response

class MatchAdapter: RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {
    class MatchViewHolder(val binding: AdapterMatchBinding): RecyclerView.ViewHolder(binding.root) {

    }

    var matchInfo = mutableListOf<Response>()

    fun setMatchList(match: List<Response>){
        this.matchInfo = match.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMatchBinding.inflate(inflater,parent,false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val match = matchInfo[position]
        holder.binding.nameteam1.text = match.teams.home.name
        Glide.with(holder.itemView.context).load(match.teams.home.logo).into(holder.binding.logoTeam1)
        holder.binding.time.text = match.fixture.date
        holder.binding.nameteam2.text = match.teams.away.name
        Glide.with(holder.itemView.context).load(match.teams.away.logo).into(holder.binding.logoTeam2)
    }

    override fun getItemCount(): Int {
        return matchInfo.size
    }
}