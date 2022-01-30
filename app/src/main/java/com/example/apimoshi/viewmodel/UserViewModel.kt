package com.example.apimoshi.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.apimoshi.TAG
import com.example.apimoshi.network.models.UserModel
import com.example.apimoshi.repository.UserRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class UserViewModel( private val userRepository: UserRepository) : ViewModel(){

    private var _users : MutableLiveData<List<UserModel>?> = MutableLiveData()
    val users: LiveData<List<UserModel>?> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            val response = userRepository.getUsers()
            Log.d(TAG, "Inside UserViewModel : getUsers() : coroutine : response is $response")
            _users.postValue(response)
        }
    }

    class Factory(
        private val userRepository: UserRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
                return UserViewModel(userRepository) as T
            } else {
                throw RuntimeException("Could not create instance of UserViewModel")
            }
        }
    }
}