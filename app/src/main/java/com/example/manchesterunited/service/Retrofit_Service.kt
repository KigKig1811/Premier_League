package com.example.manchesterunited.service

import com.example.manchesterunited.model.Team
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit_Service {
    //https://api-football-v1.p.rapidapi.com/teams/league/2
    //https://api-football-v1.p.rapidapi.com/v3/teams?id=33

    @GET("/teams/league/2" )
    fun getAllTeam(): Call<List<Team>>



}
