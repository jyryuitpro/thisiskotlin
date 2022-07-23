package com.example.thisiskotlin

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.thisiskotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // 지연초기화 (주로 클래스에 사용하기 위한 문법이다!)
    // lateinit var 변수명: 타입 -> 기본형에는 사용할 수 없다!
    lateinit var name: String // String은 기본형: Int, Long, float, Double... 이 아니다
    lateinit var person: Person
//    var name: String = "Scott"

    // val 변수명 by lazy { 변수에 들어갈 클래스생성자 또는 값 }
    // lazy는 기본형에도 사용가능하다
    val age by lazy {
//        Person()
        21
    }

    val binding by lazy {
        // inflate: ActivityMainBinding를 생성을 해서 넘겨주는 역할을 한다
        ActivityMainBinding.inflate(layoutInflater)
    }

    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//            binding.button.setOnClickLister()
//            binding.imageView.setImageLavel(50)
//            binding.textView.text = "반가워"

        // with: 위젯에 접근할 때 사용하는 스코프함수
        with (binding) {
//            button.setOnClickLister()
//            imageView.setImageLavel(50)
//            textView.text = "반가워"
        }

        name = "Scott"
        name = "Kelly"

        person = Person()

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

        // 배열 (정적배열)
        // Int -> IntArray
        var intArr: IntArray = IntArray(10)
        // index = 0부터 시작
        intArr[0] = 10
        intArr[1] = 20
        intArr[2] = 30
        intArr[3] = 40
        intArr[4] = 50

        intArr[9] = 100
//        intArr[10] = 110

        Log.d("TAG", "9번 인덱스의 값=${intArr[9]}")
        var weekArray = CharArray(7)
        weekArray[0] = '월'
        weekArray[1] = '화'
        weekArray[2] = '수'
        weekArray[3] = '목'
        weekArray[4] = '금'
        weekArray[5] = '토'
        weekArray[6] = '일'

        // 컬렉션 (동적배열), Generic(제네릭)
        // 리스트(배열과 동일), 뮤터블리스트
        var mutableList = mutableListOf<Int>()
        // 값 넣기
        mutableList.add(5)  // index 0
        mutableList.add(10)  // index 1
        mutableList.add(75)  // index 2
        mutableList.add(36)  // index 3
        mutableList.add(66)  // index 4

        Log.d(TAG, "3번 인덱스(네번째)의 값=${mutableList.get(3)}")
        Log.d(TAG, "3번 인덱스(네번째)의 값=${mutableList[3]}")

        // 맵 (키, 벨류)
        var mutableMap = mutableMapOf<String, String>()
        mutableMap.put("변수1", "값1")
        mutableMap.put("변수2", "값2")

        Log.d(TAG, "맵 변수1의 값은=${mutableMap.get("변수1")}")

        // for
        for (index in 1..10) {
            Log.d("TAG", "index=${index}")
        }

        for (index in 1 until 10) {
            Log.d("TAG", "index=${index}")
        }

        for (index in 1 until 10 step 2) {
            Log.d("TAG", "index=${index}")
        }

        var intA = IntArray(10)
        intA[0] = 0


        for (index in 10 downTo 1 step 2) {
            Log.d("TAG", "index=${index}")
        }

        var intArray = intArrayOf(0, 10, 20, 30, 40, 50, 60, 70, 80)

        for (value in intArray) {
            Log.d("TAG", "index=${value}")
        }

        // while
        var outCount = 0
        while (outCount < 3) {
            Log.d(TAG, "현재 out 카운트=${outCount}")
            outCount = outCount + 1
        }

        do {
            Log.d(TAG, "현재 out 카운트=${outCount}")
            outCount = outCount + 1
        } while (outCount < 3)

        // control loop
        for (index in 0..10) {
            if (index > 5) break
            Log.d(TAG, "현재 숫자=${index}")
        }

        for (index in 0..10) {
            if (index == 5) continue
            Log.d(TAG, "현재 숫자=${index}")
        }

        functionName()

        functionParam("값", 153)

        var pi = getPi()
        Log.d(TAG, "pi=${pi}")

        // 클래스를 사용하는 방법
        // 클래스의 사용
        // 1. 초기화
        var cls = 클래스() // 인스턴스 = 메모리에 로드되어 있는 클래스

        cls.variable
        cls.function()

        var log = Log()

//        log.d("태그", "메세지")
        // 2. companion object 로 만들기
        Log.d("태그", "메세지")

//        var child = Child()
//        child.showMoney()

        var parent = Parent()
        parent.showHouse()

        var child = Child()
        child.showHouse()

        var son = Son()
        var result = son.getNumber("zergling")

        var playerName: String = "메시"
        var number: Int? = null // 1. nullable
        var newVariable: Activity? = null

        Log.d("Null Test", "문자열의 길이는=${playerName.length}")

        var number2: Int = 30
        var plusResult = number2.plus(50)

        // Null Pointer Exception
        var safeCallResult = number?.plus(37) ?: 51   // 2. Safe Call, 3. Elvis Expression

        var safeCallResult2 = safeCallResult.plus(53)

        studyRun()
    }

    // 기본 함수
    fun functionName() {

    }

    // 입력값이 있는 함수
    fun functionParam(param1: String, param2: Int) {
        Log.d(TAG, "param1=${param1}, param2=${param2}")
    }

    // 출력값이 있는 함수
    fun getPi(): Double {
        return 3.141592
    }

    // 함수를 사용하는 용도 > 코드를 분류하기 위해서

    // 스코프함수
    // run, let, apply, also
    // with
    // 1. run
    fun studyRun() {
        val phones = mutableListOf<String>("010-1234-5678", "010-3456-7899", "010-1478-2369")
        val list = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)
        val names = mutableListOf<String>("Scott", "Kelly", "Michael")

        val seoulPeople = SeoulPeople()

        seoulPeople.persons.add(Person("Scott", "010-1234-5678", 19))
        seoulPeople.persons.add(Person("Scott", "010-1234-5678", 19))
        seoulPeople.persons.add(Person("Scott", "010-1234-5678", 19))

        // (run, apply) 그리고 (let, also)가 동일한 역할을 하지만 반환타입이 다르다!

        // 변수에 뭔가 액션을 취하고 변수에 다른 결괏값을 받고 싶을 때 사용한다. (run, let 공통사항!)
        // .run, apply: 내가 실행한 변수와는 상관없이, 마지막 값이 반환된다!
        val resultRun = seoulPeople.persons.run {
            add(Person("Scott", "010-1234-5678", 19))
            add(Person("Scott", "010-1234-5678", 19))
            add(Person("Scott", "010-1234-5678", 19))
            size
//            11
        }

        // run과 동일하지만 alias (persons)를 지정할 수 있다.
        val resultLet = seoulPeople.persons.let { persons ->
            persons.add(Person("Scott", "010-1234-5678", 19))
            persons.add(Person("Scott", "010-1234-5678", 19))
            persons.add(Person("Scott", "010-1234-5678", 19))
        }

        // ==================================.apply, also 스코프 함수 안에서 자기 자신을 되돌려준다.

        val resultApply = seoulPeople.persons.apply {
            // 즉 마지막에 있는 문장이랑 상관없이 persons에 반영된 (person 6개가 들어있는) persons 배열을 resultApply반환해준다.
            add(Person("Scott", "010-1234-5678", 19))
            add(Person("Scott", "010-1234-5678", 19))
            add(Person("Scott", "010-1234-5678", 19))
            11
        }

        Log.d("스코프함수", "resultApply=${resultApply}")

        // apply와 동일하지만 alias (persons)를 지정할 수 있다.
        val resultAlso = seoulPeople.persons.also { persons ->
            persons.add(Person("Scott", "010-1234-5678", 19))
            persons.add(Person("Scott", "010-1234-5678", 20))
            persons.add(Person("Scott", "010-1234-5678", 21))
            12
        }

        Log.d("스코프함수", "resultAlso=${resultAlso}")

        phones.run {
            add("010-9356-8541")
        }

        list.run {
            // 변수가 가지고 있는 타입을 통째로 넘겨준다.
        }
    }
}

class Log {

    companion object {
        var variable = "난 누구"

        fun d(tag: String, msg: String) {
            print("[$tag] : [$msg]")
        }
    }
}

// 클래스 변수(프로퍼티, property)와 함수(메서드, method)의 모음
class 클래스 {

    init {
        // 클래스를 초기화하면 호출된다
    }

    var variable: String = ""

    fun function() {
        var variable_local = ""
    }
}

// 상속을 사용하는 이유
// 1. 기존에 작성된 코드를 재활용하기 위해서
// 2. 코드를 재활용하는데 -> 체계적으로 구조로 사용하기 위해서
open class Parent {
    var money = 50000000000
    open var house = "강남 200평 아파트"

    open fun showHouse() {
        Log.d("클래스", "parent house=${house}")
    }
}

// override: 재정의
class Child : Parent() {
    // 상속받으면, 아빠클래스의 프로퍼티와 메서드를 내것처럼 사용할 수 있다
    override var house = "강남 10평 오피스텔"

    fun showMoney() {
        Log.d("클래스", "money=${money}")
    }

    override fun showHouse() {
        Log.d("클래스", "child house=${house}")
    }
}

class Son {

    fun getNumber(zergling: String): Int {
        return 1
    }

    fun getNumber(zergling: String, hidra: String): Int {
        return 2
    }
}

//class Person {
//    var name = ""
//    var age = ""
//    var address = ""
//    var tel = ""
//}

class SeoulPeople {
    var persons = mutableListOf<Person>()

    init {
        persons.add(Person("Scott", "010-1234-5678", 19))
        persons.add(Person("Kelly", "010-3456-7899", 20))
        persons.add(Person("Michael", "010-1478-2369", 21))
    }
}

data class Person (
    var name: String = "",
    var phone: String = "",
    var age: Int = 21
)