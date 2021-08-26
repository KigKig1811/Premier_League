package com.example.manchesterunited.adapter

import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.manchesterunited.databinding.AdapterMatchBinding
import com.example.manchesterunited.model.fixtures.Response
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

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
        val date = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(match.fixture.date.toString())
        var formattedDate = SimpleDateFormat("dd-MM-yyyy").format(date)
        var time = SimpleDateFormat("HH:mm").format(date)
       // holder.binding.nameteam1.text = match.teams.home.name
        Glide.with(holder.itemView.context).load(match.teams.home.logo).into(holder.binding.logoTeam1)
        holder.binding.time.text =formattedDate
        holder.binding.date.text = time
        Glide.with(holder.itemView.context).load(match.teams.away.logo).into(holder.binding.logoTeam2)
    }
    override fun getItemCount(): Int {
        return matchInfo.size
    }
    interface GetDate{
        fun getDate(position: Int)
    }
}