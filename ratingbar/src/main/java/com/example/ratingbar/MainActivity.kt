package com.example.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ratingbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            ratingBar.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
                if (fromUser) {
                    textView.text = "$rating"
                }
            }
        }
    }
}