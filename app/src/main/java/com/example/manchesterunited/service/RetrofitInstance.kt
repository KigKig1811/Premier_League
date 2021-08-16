package com.example.manchesterunited.service

import com.example.manchesterunited.reponsitory.MainRepository
import com.example.manchesterunited.utils.Constants.Companion.BASE_URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
     val request =  OAuthInterceptor()
    val logging = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.HEADERS)

    val client = OkHttpClient.Builder()
        .addInterceptor(OAuthInterceptor())
        .addInterceptor(logging)
        .build()


    var retrofitService: Retrofit_Service? = null

    fun getInstance(): Retrofit_Service {
        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofitService = retrofit.create(Retrofit_Service::class.java)

        }
        return retrofitService!!
    }



}


