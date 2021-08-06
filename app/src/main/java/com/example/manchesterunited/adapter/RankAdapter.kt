package com.example.manchesterunited.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manchesterunited.databinding.AdapterRankBinding
import com.example.manchesterunited.model.Standings

class RankAdapter: RecyclerView.Adapter<RankAdapter.RankViewHolder>() {

    var ranks = mutableListOf<Standings>()

    fun setRankList(ranks: List<Standings>){
        this.ranks = ranks.toMutableList()
        notifyDataSetChanged()
    }
    class RankViewHolder(val binding: AdapterRankBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterRankBinding.inflate(inflater,parent,false)
        return RankViewHolder(binding)

    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        val rank =  ranks[position]
        holder.binding.rank.text = rank.rank
        holder.binding.nameTeam.text = rank.teamName
        holder.binding.win.text = rank.win
        holder.binding.draw.text = rank.draw
        holder.binding.lose.text = rank.lose
        holder.binding.goalsDiff.text = rank.goalsDiff
        holder.binding.points.text = rank.points

    }

    override fun getItemCount(): Int {
        return ranks.size
    }
}