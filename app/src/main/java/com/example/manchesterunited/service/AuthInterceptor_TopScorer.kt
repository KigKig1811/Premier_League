package com.example.manchesterunited.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor_TopScorer: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
            .newBuilder()
            .addHeader("apikey", "e1d5dae0-f2a4-11eb-a6e3-cbd60bd9853e")
            .build()
        return chain.proceed(request)
    }
}