package com.example.newsapp.mappers

import com.example.newsapp.data.model.ArticleDTO
import com.example.newsapp.domain.model.Article

fun List<ArticleDTO>.toDomain():List<Article>{
    return map {
        Article(
            content = it.content?:"",               //if null then return ""
            description = it.description?:"",
            title = it.title?: "",
            urlToImage = it.urlToImage?:""
        )
    }
}