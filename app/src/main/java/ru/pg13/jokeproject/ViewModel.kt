package ru.pg13.jokeproject

import androidx.lifecycle.ViewModel
import ru.pg13.jokeproject.data.ApiService

class ViewModel(private val service: ApiService): ViewModel() {

    fun getJoke() = service.getJoke()
}