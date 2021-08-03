package com.example.manchesterunited.api

import okhttp3.OkHttpClient
import okhttp3.Request

class RetrofitService {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://api-football-v1.p.rapidapi.com/teams/league/2")
        .get()
        .addHeader("x-rapidapi-key", "fb5482bb2amshc633db328eb75eap1fe9bbjsn805390ae7858")
        .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
        .build()

    val response = client.newCall(request).execute()


}