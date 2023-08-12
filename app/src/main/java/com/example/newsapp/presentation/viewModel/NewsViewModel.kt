package com.example.newsapp.presentation.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.domain.use_case.GetNewsArticleUseCase
import com.example.newsapp.presentation.HomeStateHolder
import com.example.newsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val getNewsArticleUseCase: GetNewsArticleUseCase) : ViewModel() {

     val article = mutableStateOf(HomeStateHolder())

    init {
        getNewsArticle()
    }

    private fun getNewsArticle(){
        getNewsArticleUseCase().onEach{
            when(it){
                is Resource.Loading -> {
                    article.value = HomeStateHolder(isLoading = true)
                }
                is Resource.Success -> {
                    article.value = HomeStateHolder(data = it.data)
                }
                is Resource.Error -> {
                    article.value = HomeStateHolder(error = it.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}