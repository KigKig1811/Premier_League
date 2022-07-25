package com.example.manchesterunited.service

import com.example.manchesterunited.model.Data
import com.example.manchesterunited.model.PlayerOfTeam.PlayerOfTeam
import com.example.manchesterunited.model.fixtures.Match
import com.example.manchesterunited.model.topScorerNew.TopScorersPlayerNews
import com.example.standing.model.TopScorer
import com.example.standing2020.model.Standing

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
    //https://api-football-v1.p.rapidapi.com/v3/fixtures

    @GET("teams/league/{id}" )
    fun getAllTeam(@Path("id")  league_Id: Int): Call<Data>

    @GET("v3/players/squads")
    fun getAllPlayerofTeam(@Query("team") team : Int): Call<PlayerOfTeam>

    @GET("v2/stages/{stage_Id}/standing")
    fun getStading(@Path("stage_Id") stage_Id: Int): Call<Standing>

    @GET("api/v1/soccer/topscorers")
    fun getTopScorer(@Query("season_id") season_id: Int): Call<TopScorer>

    @GET("players/topscorers")
    fun getTopScorersNew(@Query("season") season_id: Int,@Query("league") league_Id: Int): Call<TopScorersPlayerNews>

    @GET("v3/fixtures")
    fun getFixtures(
        @Query("league") league: Int,
        @Query("next") next: Int): Call<Match>









}
