package ru.pg13.jokeproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import ru.pg13.jokeproject.data.models.Joke
import ru.pg13.jokeproject.databinding.ActivityMainBinding
import ru.pg13.jokeproject.interfaces.DataCallback

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = (application as MyApplication).viewModel
        viewModel.init(object : DataCallback {
            override fun provideText(text: String) {
                binding.textView.text = text
            }

            override fun provideIconRes(id: Int) {
                binding.imageView.setImageResource(id)
            }

        })
    }
}