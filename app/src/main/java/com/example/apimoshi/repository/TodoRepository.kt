package com.example.apimoshi.repository

import com.example.apimoshi.network.ApiManager
import com.example.apimoshi.network.models.Todo

class TodoRepository(
    private val apiManager: ApiManager
) {
    suspend fun getTodos(): List<Todo>? {
        return try {
            val response = apiManager.getTodos()
            if (response.isSuccessful) {
                response.body()
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            emptyList()
        }
    }

}