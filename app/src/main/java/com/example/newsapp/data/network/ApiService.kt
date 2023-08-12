package com.example.newsapp.data.network

import com.example.newsapp.data.model.NewsDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // Define the Retrofit endpoint for getting news articles
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "80b068c9f5bb4099a9bb21bffbec15d9"
    ): Response<NewsDTO>
}
