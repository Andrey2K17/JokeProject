package ru.pg13.jokeproject

import androidx.lifecycle.ViewModel
import ru.pg13.jokeproject.data.CloudDataSource
import ru.pg13.jokeproject.data.ErrorType
import ru.pg13.jokeproject.data.JokeCloudCallback
import ru.pg13.jokeproject.data.models.FailedJoke
import ru.pg13.jokeproject.data.models.Joke
import ru.pg13.jokeproject.interfaces.DataCallback

class ViewModel(
    private val cloudDataSource: CloudDataSource
) : ViewModel() {

    private var dataCallback: DataCallback? = null

    fun init(callback: DataCallback) {
        dataCallback = callback
        cloudDataSource.getJoke(object : JokeCloudCallback {
            override fun provide(joke: Joke) {
                dataCallback?.let {
                    joke.toBaseJoke().map(it)
                }
            }

            override fun fail(error: ErrorType) {
                val failure = if (error == ErrorType.NO_CONNECTION) "Нет соединения " else "Сервис недоступен"
                dataCallback?.let {
                    FailedJoke(failure).map(it)
                }
            }
        })
    }
}