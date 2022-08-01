package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.spinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 데이터
        var data = listOf<String>("-선택하세요-", "1월", "2월", "3월")

        // 스피너 "컨테이너"에 넣어주기 위한 중간 매개역할(adapter)
        // 데이터가 adapter를 거쳐서 스피터 "컨테이너"에 뿌려지게 됩니다.
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)

        with(binding) {
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {

                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val selected = data.get(position)
                    result.text = selected
                }
            }
        }
    }
}