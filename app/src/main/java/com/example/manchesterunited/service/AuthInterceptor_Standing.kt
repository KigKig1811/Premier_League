package com.example.manchesterunited.service

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor_Standing: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
            .newBuilder()
            .addHeader("x-rapidapi-key", "fb5482bb2amshc633db328eb75eap1fe9bbjsn805390ae7858")
            .addHeader("x-rapidapi-host", "elenasport-io1.p.rapidapi.com")
            .build()
        return chain.proceed(request)
    }
}