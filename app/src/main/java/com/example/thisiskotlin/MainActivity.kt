package com.example.thisiskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myName = "류지영"
        Log.d(TAG, "my name=$myName")
        myName = "코틀린"
        Log.d(TAG, "my name=$myName")
        val PI = 3.141592
        Log.d(TAG, "PI=$PI")

        var myNumbers = "1,2,3,4,5,6"
//        var thisWeekNumbers = "5,6,7,8,9,10"
        var thisWeekNumbers = "1,2,3,4,5,6"
        if (myNumbers == thisWeekNumbers) {
            Log.d(TAG, "당첨되었습니다")
//            textLog.text = "당첨되었습니다"
        } else {
            Log.d(TAG, "당첨되지 않았습니다")
//            textLog.text = "당첨되지 않았습니다"
        }

        for (index in 1..10) {
//            textLog.append("\n현재 숫자는 ${index}입니다")
            Log.d(TAG, "현재 숫자는 ${index}입니다")
        }

        var variable: String = "홍길동"

        var variable2: String
        variable2 = "안녕하세요"

//        variable = 123
        variable = "다른값"

        // 코틀린의 기본타입
        // 실수형
        var doubleValue: Double = 35.6
//        var floatValue: Float = 123.7F
        // 정수형
//        var intValue: Int = 12345678
        var longValue: Long = 32_147_483_647L
//        var shortValue: Short = 123
//        var byteValue: Byte = 127
        // 문자형
        var charValue: Char = 'a'
        var stringValue: String = "문자형 길이에 상관없이 값을 입력할 수 있다 == 크기를 특정할 수 없다."
        // 불린형
        var booleanValue: Boolean = true

        booleanValue = false

        val VALVALUE: Boolean = true

//        valValue = false

        var helloWorld = "안녕 세상아!"
        var hello_World = "안녕 세상아!"

        var first = 300
        var second = 500
        var third = 270

        // 비교연산자 <, >, >=, <=, ==, !=
        var result1 = first < 500
        Log.d("TAG", "첫번째 결과=${result1}")

        var result2 = first < 500
        Log.d("TAG", "두번째 결과=${result2}")
        // 논리연산자
        var logic1 = result1 && result2
        Log.d("TAG", "논리연산 && 결과=${logic1}")

        var logic2 = result1 || result2
        Log.d("TAG", "논리연산 || 결과=${logic2}")
        // 부정연산자
        var logic3 = !result1
        Log.d("TAG", "부정연산 ! 결과=${logic3}")
        // if
        var out = 0
        var strike = 2
        if (strike > 2) {
            out = out + 1
            fun process1() { }
        } else if (strike > 3) {

        } else {
            fun process2() { }
        }
        Log.d("TAG", "결과 out=${out}")

        fun process1() { }
        fun process2() { }

        // 코틀린 when - if문의 확장판
        var month = 9
        when (month) {
            3 -> Log.d("TAG", "3월입니다.")
            6 -> {
                Log.d("TAG", "6월입니다.")
            }
            9 -> {
                Log.d("TAG", "9월입니다.")
            }
            10, 11, 12 -> {
                Log.d("TAG", "10, 11, 12월입니다.")
            }
            in 1..2 -> {
                Log.d("TAG", "1, 2월입니다.")
            }
            else -> {
                Log.d("TAG", "else 입니다.")
            }
        }
    }
}