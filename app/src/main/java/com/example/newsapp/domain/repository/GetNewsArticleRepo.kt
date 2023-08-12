package com.example.newsapp.domain.repository

import com.example.newsapp.domain.model.Article


// in domain layer we just write the interface of repository and implement it in data layer


interface GetNewsArticleRepo{

    suspend fun getNewsArticle():List<Article>

}