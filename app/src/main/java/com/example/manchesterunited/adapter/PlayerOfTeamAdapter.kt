package com.example.manchesterunited.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterTeamDetailBinding
import com.example.manchesterunited.model.PlayerOfTeam.Player

class PlayerOfTeamAdapter: RecyclerView.Adapter<PlayerOfTeamAdapter.PlayerViewHolder>() {

    var players = mutableListOf<Player>()

    fun setPlayerList(player: List<Player>){
        this.players = player.toMutableList()
        notifyDataSetChanged()
    }
    class PlayerViewHolder(val binding: AdapterTeamDetailBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTeamDetailBinding.inflate(inflater,parent,false)
        return PlayerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.numberPlayer.text = player.number.toString()
        holder.binding.namePlayer.text = player.name
        holder.binding.birthPlayer.text = player.age.toString()
        holder.binding.position.text = player.position
        Glide.with(holder.itemView.context).load(player.photo).into(holder.binding.imagePlaer)
        Log.d("AAA",  players.size.toString())



    }

    override fun getItemCount(): Int {
        return players.size

    }
}