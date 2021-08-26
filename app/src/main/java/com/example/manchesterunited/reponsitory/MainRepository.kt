package com.example.manchesterunited.reponsitory

import com.example.manchesterunited.service.Retrofit_Service

class MainRepository constructor(private val retrofitService: Retrofit_Service) {

    fun getAllTeam() = retrofitService.getAllTeam(2)

    fun getAllPlayerofTeam() = retrofitService.getAllPlayerofTeam(33)

    fun getStanding() = retrofitService.getStading(2053)

    fun getTopScorer() = retrofitService.getTopScorer(352)

    fun getFixtures() = retrofitService.getFixtures(39,30)


}