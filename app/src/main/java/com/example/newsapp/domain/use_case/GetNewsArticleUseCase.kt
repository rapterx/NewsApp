package com.example.newsapp.domain.use_case

import com.example.newsapp.domain.model.Article
import com.example.newsapp.domain.repository.GetNewsArticleRepo
import com.example.newsapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

class GetNewsArticleUseCase @Inject constructor(private val getNewsArticleRepo: GetNewsArticleRepo) {

    operator fun invoke(): Flow<Resource<List<Article>>> = flow {

        emit(Resource.Loading(""))
        try {
            emit(Resource.Success(getNewsArticleRepo.getNewsArticle()))
        }catch (e: Exception){
            emit(Resource.Error(e.message))
        }

    }

}