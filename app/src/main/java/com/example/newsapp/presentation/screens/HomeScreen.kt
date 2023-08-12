package com.example.newsapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.newsapp.domain.model.Article
import com.example.newsapp.presentation.viewModel.NewsViewModel
import coil.compose.rememberImagePainter


@Composable
fun HomeScreen(viewModel:NewsViewModel = hiltViewModel()) {

    val res = viewModel.article.value

    if(res.isLoading){
        Box(modifier = Modifier.fillMaxSize())
        {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

    if(res.error.isNotBlank()){
        Box(modifier = Modifier.fillMaxSize()){
            Text(text = res.error, modifier = Modifier.align(Alignment.Center))
        }
    }

    res.data?.let{
        LazyColumn{
            items(it){
                ArticleItem(it)
            }
        }
    }
}

@Composable
fun ArticleItem(it:Article) {
    Column(modifier = Modifier) {

        Image(
            painter = rememberImagePainter(data = it.urlToImage),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Text(
            text = it.title,
            style = TextStyle(
                color = Color.Gray,
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp

            ),
            modifier = Modifier.padding(12.dp)
        )
        
    }
}
