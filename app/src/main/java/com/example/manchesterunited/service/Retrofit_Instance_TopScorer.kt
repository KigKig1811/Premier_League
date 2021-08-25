package com.example.manchesterunited.service

import com.example.manchesterunited.utils.Constants.Companion.BASE_URl_TopScorer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_Instance_TopScorer {

    val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    val client = OkHttpClient.Builder()
        .addInterceptor(AuthInterceptor_TopScorer())
        .addInterceptor(logging)
        .build()

    var retrofitService: Retrofit_Service? = null
    fun getInstance_TopScorer() :Retrofit_Service{
        if(retrofitService == null){
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URl_TopScorer)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(Retrofit_Service::class.java)
        }
        return retrofitService!!
    }
}