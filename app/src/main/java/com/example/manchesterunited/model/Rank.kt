package com.example.manchesterunited.model

import com.google.gson.annotations.SerializedName

data class Rank(
    val api:Api
)
data class Api(
    val results: Int,
    @SerializedName("rank")
    val rank: List<Standings>
)
data class Standings(
    val draw: String,
    val goalsAgainst: String,
    val goalsDiff: String,
    val goalsFor: String,
    val group: String,
    val lastUpdate: String,
    val lose: String,
    val matchsPlayed: String,
    val points: String,
    val rank: String,
    val teamName: String,
    val team_id: String,
    val win: String
)