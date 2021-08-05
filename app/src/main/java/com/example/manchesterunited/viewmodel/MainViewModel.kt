package com.example.manchesterunited.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manchesterunited.model.*
import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.view.MainActivity
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
       /* repository.enqueue(object : Callback<leagues>{
            override fun onResponse(call: Call<leagues>, response: Response<leagues>) {

                val arrayTeam: ArrayList<TeamX> = ArrayList(response.body()?.api?.teams)
                league.postValue(response.body())


            }
            override fun onFailure(call: Call<leagues>, t: Throwable) {
            Log.d("AAA","ERROR")
             errorMessage.postValue(t.message)
            }

        })*/
    }
}



