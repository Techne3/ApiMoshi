package com.example.apimoshi.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserModel(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)