package com.example.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) { // Entry Point (시작점)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("from1", "Hello Bundle")
            intent.putExtra("from2", 2021)
            startActivityForResult(intent, 99)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("MainActivity", "onActivityResult")
        if (requestCode == Activity.RESULT_OK) {
            Log.d("MainActivity", "Activity.RESULT_OK")
            when(resultCode) {
                99 -> {
                    Log.d("MainActivity", "resultCode")
                    data?.getStringExtra("returnValue").let { message ->
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}