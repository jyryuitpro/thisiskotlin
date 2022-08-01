package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ActivityMainBinding
import com.example.recycleview.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 불러온다
        val data = loadData()

        // 2. 어댑터를 생성한다.
        val customAdapter = CustomAdapter(data)

        // 3. 화면의 RecyclerView와 연결
        binding.rercyclerView.adapter = customAdapter

        // 4. 레이아웃 매니저 설정
        binding.rercyclerView.layoutManager = LinearLayoutManager(this)
    }

    fun loadData(): MutableList<Memo> {
        val memoList = mutableListOf<Memo>()
        for (no in 1..100) {
            val title = "이것이 안드로이드다 $no"
            val date = System.currentTimeMillis()
            val memo = Memo(no, title, date, "류지영", "010-1234-5678")
            memoList.add(memo)
        }
        return memoList
    }
}

// RecyclerView.Adapter: 데이터 전체를 관리합니다.
// item_recycler.xml 개별 아이템에 값을 세팅해주는 것이 Holder의 역할입니다.
// Adapter클래스가 사용하는 데이터 목록을 줘야합니다.
// val이라는 예약어를 붙이면 listData를 전역변수처럼 사용할 수 있습니다.
class CustomAdapter(val listData: MutableList<Memo>) : RecyclerView.Adapter<CustomAdapter.Holder>() {

    // 화면에 뿌려줄 item_recycler.xml을 하나 하나 생성합니다.
    // 화면 기준 30개의 목록이 보여질 수 있다면, 딱 30번만 호출됩니다.
    // 그리고 나머지 31번부터 100번까지는 스크롤을 올리는 순간 1번에 있는 Holder를 31번에서 가져다 사용합니다. (재사용)
    // 즉, 화면에 보이는 만큼만 생성해두고, 재사용하는게 Recycler View의 특징입니다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        // Activity에서는 항상 전체화면이니까 layoutInflater만 넘겨주면 되는데
        // Adapter에서는 각각의 Holder가 부분 부분 쓰여지기 때문에 표시되는 뷰의 정보도 함께 넘겨줘야합니다.
        // 아래 인자는 항상 고정입니다.
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    // 목록이 30개이면 30번이 다 호출이 됩니다.
    // 30개까지는 onCreateViewHolder에서 만들어진 쭉 그대로 사용을 합니다.
    // 31번째부터는 onCreateViewHolder가 만든 첫번째꺼를 가져와서 사용합니다. (재사용)
    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 1. 사용할 데이터를 꺼내고
        val memo = listData.get(position)

        // 2. 홀더에 데이터를 전달
        holder.setMomo(memo)
    }

//    override fun getItemCount(): Int {
//        return listData.size
//    }
//    override fun getItemCount(): Int = listData.size
    // 데이터 목록의 갯수
    override fun getItemCount() = listData.size

    // item_recycler.xml 개별 아이템에 값을 세팅해줍니다.
    // 생성자로 Holder가 사용하는 뷰를 넘겨줘야합니다.
    // val이라는 예약어를 붙이면 binding을 전역변수처럼 사용할 수 있습니다.
    class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root) {
        // 클릭처리는 init에서만 해야합니다.
        // 3. 받은 데이터를 화면에 출력합니다.

        // 화면에 한 행, 한 행 뿌려질 때, 뿌리고 끝나는게 아니라, 여기서 사용한 데이터를 변수를 하나 선언에서 담아두면 좋습니다.
        // 데이터가 항상 담긴다면 null처리할 필요없이 lateinit var로 처리해도 됩니다.
        lateinit var currentMemo: Memo

        init {
            binding.root.setOnClickListener {
                // val title = binding.textTitle.text
                // context는 binding에서 꺼낼 수 있습니다.
                Toast.makeText(binding.root.context, "클릭된 아이템 : ${currentMemo.title} ${currentMemo.writer}", Toast.LENGTH_SHORT).show()
            }
        }

        fun setMomo(memo: Memo) {
            // memo가 세팅되는 순간 해당 메모를 담아줍니다.
            // 현재 행의 메모를 알려줍니다.
            currentMemo = memo

            with(binding) {
                textNo.text = "${memo.no}"
                textTitle.text = memo.title

                val sdf = SimpleDateFormat("yyyy-MM-dd")
                val formatedDate = sdf.format(memo.timestamp)
                textDate.text = formatedDate
            }
        }
    }
}