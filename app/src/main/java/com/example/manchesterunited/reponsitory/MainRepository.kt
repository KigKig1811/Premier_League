package com.example.manchesterunited.reponsitory

import com.example.manchesterunited.service.Retrofit_Service

class MainRepository constructor(private val retrofitService: Retrofit_Service) {

    fun getAllTeam() = retrofitService.getAllTeam(2)
    fun getRank() = retrofitService.getRanking(2)
}