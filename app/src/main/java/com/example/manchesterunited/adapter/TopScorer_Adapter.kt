package com.example.manchesterunited.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manchesterunited.databinding.AdapterTopscorerBinding
import com.example.manchesterunited.model.Teams
import com.example.standing.model.Data


class TopScorer_Adapter : RecyclerView.Adapter<TopScorer_Adapter.TopScorerViewHolder>() {

    var topScorers = mutableListOf<Data>()

    fun setTopScorerList(topScorer: List<Data>) {
        this.topScorers = topScorer.toMutableList()
        notifyDataSetChanged()
    }

    class TopScorerViewHolder(val binding: AdapterTopscorerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopScorerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTopscorerBinding.inflate(inflater, parent, false)
        return TopScorerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopScorerViewHolder, position: Int) {
        val topScorer = topScorers[position]
        holder.binding.tvRank.text = topScorer.pos.toString()
        holder.binding.tvNamePlayer.text = topScorer.player.player_name
        holder.binding.tvNameTeam.text = topScorer.team.team_name
        holder.binding.tvScorer.text = topScorer.goals.overall.toString()
        Log.d(
            "AAA", topScorers.size.toString()
        )

    }

    override fun getItemCount(): Int {
        return topScorers.size
    }
}
