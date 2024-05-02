package com.example.testkotlin.repository


import com.example.testkotlin.models.ArticlesReponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ApiInterface {
    //get  request and end point is called "top-headlines"
    @GET("top-headlines")
    fun getNews(@Query("sources") sources: String, @Query("apiKey") apiKey: String) : Call<ArticlesReponse>

}
