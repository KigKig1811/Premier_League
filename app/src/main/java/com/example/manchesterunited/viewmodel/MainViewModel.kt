package com.example.manchesterunited.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manchesterunited.model.*
import com.example.manchesterunited.model.PlayerOfTeam.*

import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.model.PlayerOfTeam.PlayerOfTeam
import com.example.manchesterunited.model.fixtures.Match
import com.example.manchesterunited.model.fixtures.Response
import com.example.manchesterunited.model.topScorerNew.TopScorersPlayerNews
import com.example.standing.model.TopScorer
import com.example.standing2020.model.Standing
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response as Re

class MainViewModel constructor(private val repository: MainRepository) : ViewModel() {


    var team = ArrayList<Teams>()
    val teams = MutableLiveData<List<Teams>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllTeam() {

        val repository = repository.getAllTeam()
        repository.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Re<Data>) {
                val data: Data? = response.body()
                if (data != null && data.api.teams != null) {
                    team = data.api.teams as ArrayList<Teams>
                    teams.postValue(team)
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }
        })
    }

    var player = ArrayList<Player>()
    val players = MutableLiveData<List<Player>>()
    fun getAllPlayerofTeam() {

        val repository = repository.getAllPlayerofTeam()
        repository.enqueue(object : Callback<PlayerOfTeam> {
            override fun onResponse(
                call: Call<PlayerOfTeam>,
                response: retrofit2.Response<PlayerOfTeam>
            ) {
                val allPlayer: PlayerOfTeam? = response.body()
                if (allPlayer != null && allPlayer.response != null) {
                    player = allPlayer.response.get(0).players as ArrayList<Player>
                    players.postValue(player)
                }
            }

            override fun onFailure(call: Call<PlayerOfTeam>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }
        })

    }

    var standing = ArrayList<com.example.standing2020.model.Data>()
    var standings = MutableLiveData<List<com.example.standing2020.model.Data>>()

    fun getStanding() {
        val repository = repository.getStanding()
        repository.enqueue(object : Callback<Standing> {
            override fun onResponse(call: Call<Standing>, response: retrofit2.Response<Standing>) {
                val data: Standing? = response.body()
                if (data != null && data.data != null) {
                    standing = data.data as ArrayList<com.example.standing2020.model.Data>
                    standings.postValue(standing)
                }
            }

            override fun onFailure(call: Call<Standing>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }
        })
    }

    var playerTopScorer = ArrayList<com.example.standing.model.Data>()
    val playerTopScorers = MutableLiveData<List<com.example.standing.model.Data>>()

    fun getTopScorer() {
        val repository = repository.getTopScorer()
        repository.enqueue(object : Callback<TopScorer> {
            override fun onResponse(
                call: retrofit2.Call<TopScorer>,
                response: retrofit2.Response<TopScorer>
            ) {
                val dataTopScorer: TopScorer? = response.body()
                if (dataTopScorer != null && dataTopScorer.data != null) {
                    playerTopScorer =
                        dataTopScorer.data as ArrayList<com.example.standing.model.Data>
                    playerTopScorers.postValue(playerTopScorer)
                }
            }

            override fun onFailure(call: retrofit2.Call<TopScorer>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }
        })
    }

    var matchList = ArrayList<Response>()
    val matchLD = MutableLiveData<List<Response>>()


    fun getFixtures() {
        val repository = repository.getFixtures()
        repository.enqueue(object : Callback<Match> {
            override fun onResponse(call: Call<Match>, response: retrofit2.Response<Match>) {
                val dataFixtures: Match? = response.body()
                if (dataFixtures != null && dataFixtures.response != null) {
                    matchList = dataFixtures.response as ArrayList<Response>
                    matchLD.postValue(matchList)
                }
            }

            override fun onFailure(call: Call<Match>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }
        })
    }
    var listTopScorerLiveData = MutableLiveData<List<TopScorersPlayerNews.Response>>()

    fun getTopScorersNew() {
        val repository = repository.getTopScorerNew()
        repository.enqueue(object: Callback<TopScorersPlayerNews> {
            override fun onResponse(
                call: Call<TopScorersPlayerNews>,
                response: retrofit2.Response<TopScorersPlayerNews>
            ) {
                val topScoresResponse: TopScorersPlayerNews? = response.body()
                if (topScoresResponse != null && !topScoresResponse.response.isNullOrEmpty()){
                    topScoresResponse.response.let {
                        listTopScorerLiveData.postValue(it as List<TopScorersPlayerNews.Response>?)
                    }
                }
            }

            override fun onFailure(call: Call<TopScorersPlayerNews>, t: Throwable) {
                Log.d("AAA", "ERROR")
            }

        })
    }
}








