package com.example.manchesterunited.model

import com.google.gson.annotations.SerializedName

data class Api(
    val results: Int,
    @SerializedName("teams")
    val teams: List<TeamX>
)