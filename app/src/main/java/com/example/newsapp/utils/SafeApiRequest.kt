package com.example.newsapp.utils
import android.util.Log
import org.json.JSONObject
import retrofit2.Response

//to handle api calls safely

abstract class SafeApiRequest {

//    fun which can work with any generic type T
//    call is a parameter that will be passed and has return type Response<T>

    suspend fun <T : Any> safeApiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
            return response.body()!!
        } else {

//            string builder will declare the string builder and initialises a string with name message
//            we use it when we need to modify a string


            val responseErr = response.errorBody()?.toString()
            val message = StringBuilder(responseErr)
            responseErr?.let {
                try {
                    message.append(JSONObject(it).getString("error"))
                } catch (e: Exception) {
                    // Handle the exception if needed
                }
            }
            Log.d("TAG", "safeApiRequest $message")
            throw Exception(message.toString())
        }
    }
}