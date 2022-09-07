package ru.pg13.jokeproject.data.models

import com.google.gson.annotations.SerializedName

data class JokeServerModel(
    @SerializedName("type")
    private val type: String,
    @SerializedName("value")
    private val value: Value,
)

data class Value(
    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String,
    @SerializedName("categories")
    private val categories: List<String>,
)