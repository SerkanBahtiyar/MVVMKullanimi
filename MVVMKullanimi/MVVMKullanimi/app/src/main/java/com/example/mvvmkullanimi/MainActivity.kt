package com.example.mvvmkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel.hesaplamaSonucu.observe(this){
            binding.sonuc = it
        }

        binding.buttonToplama.setOnClickListener {
            val alinanSayi1 = binding.editTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextSayi2.text.toString()

            viewModel.toplama(alinanSayi1,alinanSayi2)
        }

        binding.buttonCarpma.setOnClickListener {
            val alinanSayi1 = binding.editTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextSayi2.text.toString()

            viewModel.carpma(alinanSayi1,alinanSayi2)
        }
    }
}