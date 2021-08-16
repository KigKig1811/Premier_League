package com.example.manchesterunited.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manchesterunited.model.*

import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.view.MainActivity
import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository): ViewModel() {


    var team = ArrayList<Teams>()
    val teams = MutableLiveData<List<Teams>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllTeam(){

        val repository = repository.getAllTeam()
        repository.enqueue(object : Callback<Data>{
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val data : Data? = response.body()
                if(data != null && data.api.teams != null){
                    team = data.api.teams as ArrayList<Teams>
                    teams.postValue(team)
                }
            }
            override fun onFailure(call: Call<Data>, t: Throwable) {
                Log.d("AAA","ERROR")
            }
        })
    }

    }


       /* val repository = repository.getRank()
        repository.enqueue(object :Callback<Rank>{
            override fun onResponse(call: Call<Rank>, response: Response<Rank>) {
                val result: String = response.body().toString()
                val jsonArray: JsonArray = JsonArray(result.toInt())
                for(i in 0 until jsonArray.size()){
                    val jsonArrayRow: JsonArray = jsonArray.asJsonArray[i] as JsonArray
                    for(j in 0 until jsonArrayRow.size()){
                        val data : String = jsonArrayRow.asString[j].toString()
                    }
                }

            }

            override fun onFailure(call: Call<Rank>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
*/
        /*repository.enqueue(object : Callback<Rank>{
            override fun onResponse(call: Call<Rank>, response: Response<Rank>) {
                val rank: Rank? = response.body()
                if(rank != null  && rank.api.standings != null ){
                    standing = rank.api.standings as ArrayList<Standings>
                    standings.postValue(standing)
                }
            }
            override fun onFailure(call: Call<Rank>, t: Throwable) {
                Log.d("AAA","ERROR")
            }
        })*/





