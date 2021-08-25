package com.example.manchesterunited.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.manchesterunited.databinding.AdapterStandingBinding
import com.example.standing2020.model.Data

class StandingAdapter: RecyclerView.Adapter<StandingAdapter.StandingViewHolder>() {

    var standing = mutableListOf<Data>()

    fun setStandingList(standing: List<Data>){
        this.standing = standing.toMutableList()
        notifyDataSetChanged()
    }

    class StandingViewHolder(val binding: AdapterStandingBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterStandingBinding.inflate(inflater,parent,false)
        return StandingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StandingViewHolder, position: Int) {
        val team = standing[position]
        holder.binding.tvPos.text = team.pos.toString()
        holder.binding.tvClub.text = team.teamName
        holder.binding.tvPl.text = team.p.toString()
        holder.binding.tvWin.text = team.w.toString()
        holder.binding.tvDraw.text = team.d.toString()
        holder.binding.tvLose.text = team.l.toString()
        holder.binding.tvGD.text = team.gd.toString()
        holder.binding.tvPts.text = team.pts.toString()
    }

    override fun getItemCount(): Int {
        return  standing.size
    }
}