package ru.pg13.jokeproject

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.pg13.jokeproject.data.ApiService
import ru.pg13.jokeproject.data.CloudDataSourceImpl

class MyApplication: Application() {

    lateinit var viewModel: ViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viewModel = ViewModel(CloudDataSourceImpl(retrofit.create(ApiService::class.java)) )
    }
}