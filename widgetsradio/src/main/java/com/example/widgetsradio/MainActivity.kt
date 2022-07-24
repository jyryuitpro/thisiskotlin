package com.example.widgetsradio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.widgetsradio.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioApple -> Log.d("라디오버튼", "사과가 선택되었습니다.")
                R.id.radioBanana -> Log.d("라디오버튼", "바나나가 선택되었습니다.")
                R.id.radioOrange -> Log.d("라디오버튼", "오렌지가 선택되었습니다.")
            }
        }
    }
}