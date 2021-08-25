package com.example.manchesterunited.model.PlayerOfTeam

data class PlayerOfTeam(
    val errors: List<Any>,
    val get: String,
    val paging: Paging,
    val parameters: Parameters,
    val response: List<Response>,
    val results: Int
)