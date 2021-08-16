package com.example.manchesterunited.service

import com.example.manchesterunited.model.Data
import com.example.manchesterunited.testModel.PlayerOfTeam

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Retrofit_Service {
    //https://api-football-v1.p.rapidapi.com/teams/league/2
    //https://api-football-v1.p.rapidapi.com/v3/teams?id=33

    //https://api-football-v1.p.rapidapi.com/leagueTable/2
    //https://api-football-v1.p.rapidapi.com/v3/players/topscorers?league=39&season=2020
    //https://api-football-v1.p.rapidapi.com/v3/players/squads?team=33

    @GET("teams/league/{id}" )
    fun getAllTeam(@Path("id")  league_Id: Int): Call<Data>

    @GET("v3/players/squads?team=33")
    fun getAllPlayerofTeam(@Query("team_Id") team_Id : Int): Call<PlayerOfTeam>









}
