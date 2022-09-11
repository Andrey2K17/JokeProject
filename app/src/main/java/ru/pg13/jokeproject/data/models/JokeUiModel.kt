package ru.pg13.jokeproject.data.models

import androidx.annotation.DrawableRes
import ru.pg13.jokeproject.R
import ru.pg13.jokeproject.interfaces.DataCallback

class BaseJoke(text: String) : JokeUiModel(text) {
    override fun getIconResId() = R.drawable.ic_launcher_background
}

class FailedJoke(text: String) : JokeUiModel(text) {
    override fun getIconResId() = R.drawable.ic_launcher_foreground
}

//Модель UI
abstract class JokeUiModel(private val text: String) {

    fun text() = text

    @DrawableRes
    protected abstract fun getIconResId(): Int

    fun map(callback: DataCallback) = callback.run {
        provideText(text())
        provideIconRes(getIconResId())
    }
}