package io.jyryuitpro.sharedpreference

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import io.jyryuitpro.sharedpreference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY_FIRST_OPEN = "key_first_open"
    }

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val shared = getSharedPreferences("파일명", Context.MODE_PRIVATE)

        val firstOpen = shared.getBoolean(KEY_FIRST_OPEN, false)

        if (firstOpen) {
            binding.imageView.visibility = View.GONE
        }

        val editor = shared.edit() // 수정을 위한 에디터를 꺼낸다
        editor.putBoolean(KEY_FIRST_OPEN, true)
        editor.commit()
    }
}