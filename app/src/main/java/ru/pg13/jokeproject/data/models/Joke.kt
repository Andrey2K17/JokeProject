package ru.pg13.jokeproject.data.models

import com.google.gson.annotations.SerializedName

//Модель бизнес логики
data class Joke(
    private val type: String,
    private val value: Value,
) {
    fun toBaseJoke() = BaseJoke(value.joke)
}

data class Value(
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("categories")
    private val categories: List<String>,
)