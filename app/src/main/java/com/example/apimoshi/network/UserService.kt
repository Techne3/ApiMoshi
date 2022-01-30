package com.example.apimoshi.network

import com.example.apimoshi.network.models.UserModel
import retrofit2.http.GET
import retrofit2.Response


interface UserService {


        @GET("users")
        suspend fun getUsers(): Response<List<UserModel>>
    }