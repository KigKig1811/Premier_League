package com.example.manchesterunited.service

import com.example.manchesterunited.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Instance_Standing {
    val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    val client_Standing = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor_Standing())
        .addInterceptor(logging)
        .build()

    var retrofitService: Retrofit_Service? = null
    fun getInstance_Standing(): Retrofit_Service {
        if (Retrofit_Instance_Standing.retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL_Standing)
                .client(client_Standing)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            Retrofit_Instance_Standing.retrofitService = retrofit.create(Retrofit_Service::class.java)
        }
        return Retrofit_Instance_Standing.retrofitService!!

    }
}