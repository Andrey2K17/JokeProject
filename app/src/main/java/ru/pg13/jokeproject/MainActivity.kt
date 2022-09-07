package ru.pg13.jokeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import ru.pg13.jokeproject.data.models.JokeServerModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = (application as MyApplication).viewModel

        viewModel.getJoke().enqueue(object : retrofit2.Callback<JokeServerModel> {
            override fun onResponse(
                call: Call<JokeServerModel>,
                response: Response<JokeServerModel>
            ) {
                Log.d("test123", "response: ${response.body()}")
            }

            override fun onFailure(call: Call<JokeServerModel>, t: Throwable) {
                Log.d("test123", "throwable: ${t.message}")
            }

        })
    }
}