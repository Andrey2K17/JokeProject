package ru.pg13.jokeproject.data.models

import com.google.gson.annotations.SerializedName

//Серверная модель
data class JokeServerModel(
    @SerializedName("type")
    private val type: String,
    @SerializedName("value")
    private val value: Value,
) {
    fun toJoke() = Joke(type, value)
}