package com.example.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.activity.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    val binding by lazy { ActivitySubBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            to1.text = intent.getStringExtra("from1")
            to2.text = "${intent.getIntExtra("from2", 0)}"

            btnClose.setOnClickListener {
                // 나를 호출한 측으로 전달하는 인텐트이기 때문에 메인엑티비티라고 써줄 필요가 없다
                val returnIntent = Intent()
                val message = editMessage.toString()
                returnIntent.putExtra("returnValue", message)
                setResult(Activity.RESULT_OK, returnIntent)
                finish()
            }
        }
    }
}