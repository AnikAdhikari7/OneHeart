package com.example.oneheart.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.oneheart.R
import com.example.oneheart.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPostBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}