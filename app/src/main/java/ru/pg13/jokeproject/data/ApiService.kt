package ru.pg13.jokeproject.data

import retrofit2.Call
import retrofit2.http.GET
import ru.pg13.jokeproject.data.models.Joke

interface ApiService {
    @GET("http://api.icndb.com/jokes/random/")
    fun getJoke(): Call<Joke>
}