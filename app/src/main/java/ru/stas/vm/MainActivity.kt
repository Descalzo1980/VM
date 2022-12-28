package ru.stas.vm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.stas.vm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: MainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        /*ViewModel+LiveCycle****************************************************************/
        viewModel.startCounter()

        binding.button1.setOnClickListener {
            viewModel.seconds().observe(this, Observer {
                binding.textView1.text = it.toString()
            })
        }


        viewModel.finished().observe(this) {
            if (it) {
                binding.textView1.text = it.toString()
            }
        }
        /*ViewModel****************************************************************/
        binding.textView.text = viewModel.number.toString()

        binding.button.setOnClickListener {
            viewModel.addNumber()
            binding.textView.text = viewModel.number.toString()
        }



    }
}