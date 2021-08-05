package com.example.manchesterunited.model

import com.google.gson.annotations.SerializedName

data class Data(
    val api: Api1
)
data class Api1(
    val results: Int,
    @SerializedName("teams")
    val teams: List<Teams>
)
data class Teams(
    val code: String,
    val logo: String,
    val name: String,
    val team_id: String
)
