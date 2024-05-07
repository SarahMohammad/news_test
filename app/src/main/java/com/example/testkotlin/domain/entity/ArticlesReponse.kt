package com.example.testkotlin.domain.entity

data class ArticlesReponse(
    val status : String,
    val totalResults : Int? ,
    val articles   : ArrayList<Articles> = arrayListOf()
)
