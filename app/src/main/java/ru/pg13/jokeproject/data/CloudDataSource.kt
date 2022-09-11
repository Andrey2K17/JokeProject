package ru.pg13.jokeproject.data

import retrofit2.Call
import retrofit2.Response
import ru.pg13.jokeproject.data.models.Joke
import ru.pg13.jokeproject.data.models.JokeServerModel
import java.net.UnknownHostException

interface CloudDataSource {
    fun getJoke(callback: JokeCloudCallback)
}

interface JokeCloudCallback {
    fun provide(joke: Joke)
    fun fail(error: ErrorType)
}

enum class ErrorType {
    NO_CONNECTION,
    SERVICE_UNAVAILABLE
}

class CloudDataSourceImpl(private val service: ApiService): CloudDataSource {
    override fun getJoke(callback: JokeCloudCallback) {
        service.getJoke().enqueue(object : retrofit2.Callback<JokeServerModel> {
            override fun onResponse(
                call: Call<JokeServerModel>,
                response: Response<JokeServerModel>
            ) {
                if (response.isSuccessful) {
                    callback.provide(response.body()!!.toJoke())
                } else {
                    callback.fail(ErrorType.SERVICE_UNAVAILABLE)
                }
            }

            override fun onFailure(call: Call<JokeServerModel>, t: Throwable) {
                val errorType = if (t is UnknownHostException)
                    ErrorType.NO_CONNECTION
                else
                    ErrorType.SERVICE_UNAVAILABLE
                callback.fail(errorType)
            }
        })
    }
}