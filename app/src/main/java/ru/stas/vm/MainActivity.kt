package ru.stas.vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import ru.stas.vm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        binding.textView.text = viewModel.number.toString()

        binding.button.setOnClickListener {
            viewModel.addNumber()
            binding.textView.text = viewModel.number.toString()
        }
    }
}