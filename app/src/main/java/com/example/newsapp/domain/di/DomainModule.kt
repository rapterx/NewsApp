package com.example.newsapp.domain.di

import com.example.newsapp.data.network.ApiService
import com.example.newsapp.data.repository.GetNewsArticleRepoImpl
import com.example.newsapp.domain.repository.GetNewsArticleRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun providesGetNewsRepo(apiService: ApiService): GetNewsArticleRepo{
        return GetNewsArticleRepoImpl(apiService = apiService)
    }

}