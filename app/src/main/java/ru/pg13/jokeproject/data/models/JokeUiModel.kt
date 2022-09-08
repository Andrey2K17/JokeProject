package ru.pg13.jokeproject.data.models

import androidx.annotation.DrawableRes
import ru.pg13.jokeproject.R

class BaseJoke(text: String) : JokeUiModel(text) {
    override fun getIconResId() = R.drawable.ic_launcher_background
}

class FailedJoke(text: String) : JokeUiModel(text) {
    override fun getIconResId() = R.drawable.ic_launcher_foreground
}

//Модель UI
abstract class JokeUiModel(private val text: String) {

    fun getJokeUi() = text

    @DrawableRes
    protected abstract fun getIconResId(): Int
}