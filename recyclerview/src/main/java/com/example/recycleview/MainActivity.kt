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
// item_recycler.xml 즉, 아이템 레이아웃 하나 하나를 관리하는게 홀더입니다. 그래서 홀더를 클래스로 미리 만들어놔야합니다.
// 홀더 클래스를 어댑터에 집어넣어줍니다.

// 이 어댑터가 이 홀더를 가지고 아이템레이아웃(개별아이템)에 값을 세팅할거야 라는 의미입니다.
// 주생성자에 val이라고 붙이면 해당 데이터를 전역변수처럼 사용할 수 있다.
class CustomAdapter(val listData: MutableList<Memo>) : RecyclerView.Adapter<CustomAdapter.Holder>() {

    // 화면에 보이는 만큼만 생성해두고, 재사용하는게 리사이클러뷰의 특징이다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    // 목록이 30개이 30번이다 호출이된다. 스크롤을 하면 31번째 32번째 33번째...가 호출이되면서 30개 까지는 onCreateViewHolder에서 만들걸 그대로 쭉
    // 사용을 하고, 31번째 부터는 onCreateViewHolder가 만든 첫번째거를 가져와서 사용합니다. 돌려서 쓰는거다. 그러면서 메모리를 절약한다.
    override fun onBindViewHolder(holder: Holder, position: Int) {
        // 1. 사용할 데이터를 꺼내고
        val memo = listData.get(position)

        // 2. 홀더에 데이터를 전달
        holder.setMomo(memo)
    }

//    override fun getItemCount(): Int = listData.size
    override fun getItemCount() = listData.size

    // 그래서 홀더가 있어야되고, 따라서 홀더 클래스를 먼저 만들어야 합니다. 홀더에는 홀더가 사용할 아이템레이아웃을 던져줘야합니다.
    // RecyclerView.ViewHolder를 상속받을 때, 생성자로 홀더가 사용하는 뷰를 넘겨줘야합니다. 뷰바인딩을 사용하기 때문에 뷰를 직접 넘겨줄 수는 없습니다.
    // 먼저 홀더에 뷰바인딩을 전달하고 이 바인딩은 ItemRecyclerBinding이 되고 binding.root를 생성자에 던져줍니다.
    class Holder(val binding: ItemRecyclerBinding): RecyclerView.ViewHolder(binding.root) {
        // 화면에 뿌리지 않은 데이터가 있을 수 있고, 그 뿌리지 않은 데이터로 뭔가 할 수 있기 때문에 이런 작업을 해준 것 입니다.
        lateinit var currentMemo: Memo
        // 클릭처리는 init에서만 해야합니다.!!!! 반드시!!!! 그렇게 안하면 앱 터진다!!!!
        init {
            binding.root.setOnClickListener {
                val title = binding.textTitle.text
                Toast.makeText(binding.root.context, "클릭된 아이템 : ${currentMemo.title}", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. 받은 데이터를 화면에 출력한다.
        fun setMomo(memo: Memo) {
            currentMemo = memo
            // with 스코프함수를 사용함으로써 화면에 있는 위젯에 직접 접근할 수 있게 되었습니다.
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