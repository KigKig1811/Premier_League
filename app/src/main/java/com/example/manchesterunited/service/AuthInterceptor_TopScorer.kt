package com.example.manchesterunited.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor_TopScorer: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
            .newBuilder()
            .addHeader("X-RapidAPI-Key", "970ab3b956mshee9e618e4bf06f4p149f88jsn066449462113")
            .addHeader("X-RapidAPI-Host","api-football-beta.p.rapidapi.com" )
            .build()
        return chain.proceed(request)
    }
}