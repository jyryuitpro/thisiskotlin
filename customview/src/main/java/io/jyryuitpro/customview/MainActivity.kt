package io.jyryuitpro.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.jyryuitpro.customview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val customView = CustomView(this)
        binding.framLayout.addView(customView)
    }
}