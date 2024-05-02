package com.example.testkotlin.models

data class ArticlesReponse(
    val status : String,
    val totalResults : Int? ,
    val articles   : ArrayList<Articles> = arrayListOf()
)
