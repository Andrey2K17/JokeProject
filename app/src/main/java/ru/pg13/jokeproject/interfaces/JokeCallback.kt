package ru.pg13.jokeproject.interfaces

import ru.pg13.jokeproject.data.models.JokeUiModel

interface JokeCallback {
    fun provide(data: JokeUiModel)
}