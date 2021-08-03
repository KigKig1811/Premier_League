package com.example.manchesterunited.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.manchesterunited.model.Team
import com.example.manchesterunited.reponsitory.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository): ViewModel() {

    val teamList = MutableLiveData<List<Team>>()

    val errorMessage = MutableLiveData<String>()

    fun getAllTeam() {

        val reponsitory = repository.getAllTeam()
        reponsitory.enqueue(object : Callback<List<Team>> {
            override fun onResponse(call: Call<List<Team>>, response: Response<List<Team>>) {
                teamList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Team>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}