package com.utsman.binarmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.viewModelFactory
import com.utsman.binarmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupClick()
    }

    private fun setupClick() {
        binding.btnIncrement.setOnClickListener {
            mainViewModel.increment()

            // gak ada toast
        }

        binding.btnDecrement.setOnClickListener {
            mainViewModel.decrement()

            // gak ada toast
        }
    }

    // function parameter observer
    /*private fun observer(counter: Int) {
        Toast.makeText(this, "nilai berubah -> $counter", Toast.LENGTH_SHORT).show()
        binding.tvResultCounter.text = counter.toString()
    }*/

    private fun setupView() {
        /*mutableLiveCounter.observe(this) { counter ->
            Toast.makeText(this, "nilai berubah -> $counter", Toast.LENGTH_SHORT).show()
            binding.tvResultCounter.text = counter.toString()
        }*/

        // anonymous
        val observer: (Int) -> Unit = { counter ->
            Toast.makeText(this@MainActivity, "nilai berubah -> $counter", Toast.LENGTH_SHORT).show()
            binding.tvResultCounter.text = counter.toString()
        }

        mainViewModel.liveCounter.observe(this, observer)
    }
}