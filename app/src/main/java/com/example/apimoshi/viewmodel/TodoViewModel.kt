package com.example.apimoshi.viewmodel

import androidx.lifecycle.*
import com.example.apimoshi.network.models.Todo
import com.example.apimoshi.repository.TodoRepository
import kotlinx.coroutines.launch
import java.lang.RuntimeException

class TodoViewModel (
    private val todoRepository: TodoRepository
) : ViewModel() {

    private var _todos: MutableLiveData<List<Todo>?> = MutableLiveData()
    val todos: LiveData<List<Todo>?> = _todos

    init {
        getTodos()
    }

    private fun getTodos() {
        viewModelScope.launch {
            val response = todoRepository.getTodos()
            _todos.postValue(response)
        }
    }

    class Factory(
        private val todoRepository: TodoRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
                return TodoViewModel(todoRepository) as T
            } else {
                throw RuntimeException("Could not create instance of TodoViewModel")
            }
        }

    }
}