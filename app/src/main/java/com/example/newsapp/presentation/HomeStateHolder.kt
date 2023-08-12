package com.example.newsapp.presentation

import com.example.newsapp.domain.model.Article

data class HomeStateHolder(
    val isLoading: Boolean = false,
    val data : List<Article>? = null,
    val error : String=""
)


