package com.example.apimoshi.repository



import android.util.Log
import com.example.apimoshi.TAG
import com.example.apimoshi.network.ApiManager
import com.example.apimoshi.network.models.UserModel
import java.lang.Exception


class UserRepository(
    private val apiManager: ApiManager
) {
    suspend fun getUsers() : List<UserModel>? {
        return try {
            val response = apiManager.getUsers()
            if (response.isSuccessful) {
                Log.v(TAG," ${response.isSuccessful}")
                Log.d(TAG," $response")
                response.body()
            } else {
                emptyList()
            }
        } catch (ex : Exception) {
            emptyList()
        }
    }
}