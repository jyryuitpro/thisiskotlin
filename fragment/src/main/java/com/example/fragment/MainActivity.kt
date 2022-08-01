package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    val listFragment by lazy { ListFragment() }
    val detailFragment by lazy { DetailFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // 프래그먼트 띄우기
        setFragment()

        binding.btnSend.setOnClickListener {
            listFragment.setValue("값 전달하기")
        }
    }

    // 상세페이지
    fun goDetail() {
//        val detailFragment = DetailFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)

        // 뒤로가기 기능을 구현하기 위한 코드
        transaction.addToBackStack("detail")

        transaction.commit()
    }

    // 뒤로가기
    fun goBack() {
        onBackPressed()
    }

    fun setFragment() {
        // 액티비티에서 프래그먼트로 값 전달하는 방법
        val bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20220724)

        listFragment.arguments = bundle

        // 1. 사용할 프래그먼트 생성
//        val listFragment = ListFragment()

        // 2. 트랜잭션 생성
        val transaction = supportFragmentManager.beginTransaction()

        // 3. 트랜잭션을 통해 프래그먼트 삽입
        transaction.add(R.id.frameLayout, listFragment)
        // 내가 삽입할 레이아웃의 아이디, 만들어 놓은 프래그먼트
//        transaction.add(R.id.frameLayout, ListFragment())

        // 4. 완료처리
        transaction.commit()
    }
}