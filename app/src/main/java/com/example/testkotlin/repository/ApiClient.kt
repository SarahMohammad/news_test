package com.example.testkotlin.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val retrofit = Retrofit.Builder().
    baseUrl("https://newsapi.org/v2/").
    addConverterFactory(GsonConverterFactory.create()).
    build()

    val api = retrofit.create(ApiInterface::class.java)

}