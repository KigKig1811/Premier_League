package com.example.manchesterunited.service

import com.example.manchesterunited.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Retrofit_Service {
    //https://api-football-v1.p.rapidapi.com/teams/league/2
    //https://api-football-v1.p.rapidapi.com/v3/teams?id=33

    @GET("teams/league/{id}" )
    fun getAllTeam(@Path("id")  league_Id: Int): Call<Data>




}
