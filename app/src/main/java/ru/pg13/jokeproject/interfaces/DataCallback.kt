package ru.pg13.jokeproject.interfaces

import androidx.annotation.DrawableRes

interface DataCallback {

    fun provideText(text: String)

    fun provideIconRes(@DrawableRes id: Int)
}