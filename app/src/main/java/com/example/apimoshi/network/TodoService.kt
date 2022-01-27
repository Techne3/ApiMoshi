package com.example.apimoshi.network

import com.example.apimoshi.network.models.Todo
import retrofit2.http.GET
import retrofit2.Response


interface TodoService {

    @GET("posts")
    suspend fun getTodos() : Response<List<Todo>>

}