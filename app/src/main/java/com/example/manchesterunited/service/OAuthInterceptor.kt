package com.example.manchesterunited.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class OAuthInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
            .newBuilder()
            .url("https://api-football-v1.p.rapidapi.com/teams/league/2")
            .addHeader("x-rapidapi-key", "fb5482bb2amshc633db328eb75eap1fe9bbjsn805390ae7858")
            .addHeader("x-rapidapi-host", "api-football-v1.p.rapidapi.com")
            .build()


        return chain.proceed(request)
    }

}