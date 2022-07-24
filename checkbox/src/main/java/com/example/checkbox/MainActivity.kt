package com.example.checkbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CompoundButton
import com.example.checkbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val listener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
//            if (isChecked) Log.d("체크박스", "사과가 선택되었습니다.")
//            else Log.d("체크박스", "사과가 선택 선택 해제 되었습니다.")
//        }

        with (binding) {
            checkApple.setOnCheckedChangeListener(checkboxListener)
            checkBanana.setOnCheckedChangeListener(checkboxListener)
            checkOrange.setOnCheckedChangeListener(checkboxListener)

//            checkApple.setOnCheckedChangeListener { buttonView, isChecked ->
//                if (isChecked) Log.d("체크박스", "사과가 선택되었습니다.")
//                else Log.d("체크박스", "사과가 선택 선택 해제 되었습니다.")
//            }
//            checkBanana.setOnCheckedChangeListener { buttonView, isChecked ->
//                if (isChecked) Log.d("체크박스", "바나나가 선택되었습니다.")
//                else Log.d("체크박스", "바나나가 선택 선택 해제 되었습니다.")
//            }
//            checkOrange.setOnCheckedChangeListener { buttonView, isChecked ->
//                if (isChecked) Log.d("체크박스", "오렌지가 선택되었습니다.")
//                else Log.d("체크박스", "오렌지가 선택 선택 해제 되었습니다.")
//            }
        }
    }

    val checkboxListener = CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
        when (buttonView.id) {
            R.id.checkApple -> {
                if (isChecked) Log.d("체크박스", "사과가 선택되었습니다.")
                else Log.d("체크박스", "사과가 선택 선택 해제 되었습니다.")
            }
            R.id.checkBanana -> {
                if (isChecked) Log.d("체크박스", "바나나가 선택되었습니다.")
                else Log.d("체크박스", "바나나가 선택 선택 해제 되었습니다.")
            }
            R.id.checkOrange -> {
                if (isChecked) Log.d("체크박스", "오렌지가 선택되었습니다.")
                else Log.d("체크박스", "오렌지가 선택 선택 해제 되었습니다.")
            }
        }
    }
}