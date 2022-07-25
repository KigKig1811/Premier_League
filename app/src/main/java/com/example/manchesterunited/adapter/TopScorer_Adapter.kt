package com.example.manchesterunited.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterTopscorerBinding
import com.example.manchesterunited.model.topScorerNew.TopScorersPlayerNews
import com.example.standing.model.Data

class TopScorer_Adapter : RecyclerView.Adapter<TopScorer_Adapter.TopScorerViewHolder>() {

    private var topScorers = mutableListOf<TopScorersPlayerNews.Response>()

    @SuppressLint("NotifyDataSetChanged")
    fun setTopScorerList(topScorer: List<TopScorersPlayerNews.Response>) {
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
        holder.binding.tvRank.text = (position + 1).toString()
        holder.binding.tvNamePlayer.text = topScorer.player?.name ?: ""
        holder.binding.tvNameTeam.text = topScorer.statistics?.get(0)?.team?.name
        holder.binding.tvScorer.text = topScorer.statistics?.get(0)?.goals?.total.toString()
        Glide.with(holder.itemView.context).load(topScorer.statistics?.get(0)?.team?.logo)
            .into(holder.binding.imagePlayer)
    }

    override fun getItemCount(): Int {
        return topScorers.size
    }
}
