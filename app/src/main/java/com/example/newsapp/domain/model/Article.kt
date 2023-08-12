package com.example.newsapp.domain.model

// we take many things from the internet but we don't need to use it in our app so we create
//model clss in data as well as domain layer

data class Article(
    val content: String,
    val description: String,
    val title: String,
    val urlToImage: String
)

//to map this to our object we create a new mapper class