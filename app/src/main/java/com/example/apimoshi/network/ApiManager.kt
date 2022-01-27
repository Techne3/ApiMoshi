package com.example.apimoshi.network

class ApiManager {

    private var todoService: TodoService =
        RetrofitInstance.providesRetrofit().create(TodoService::class.java)

    suspend fun getTodos() = todoService.getTodos()

}