package com.example.newsapp.utils

//this is used to encapsulate different states that can arise when dealing with asynchronous operations

// sealed class can have a limited set of sub classes
// all the classes are inherited from resource class
sealed class Resource<T>(val data:T?=null,val message:String?=null){

    class Success<T>(data:T?): Resource<T>( data =data)

    class Loading<T>(message:String?): Resource<T>()

    class Error<T>(message:String?): Resource<T>( message = message)

}
