package com.example.apimoshi.network.models


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Company(
    val bs: String,
    val catchPhrase: String,
    val name: String
)