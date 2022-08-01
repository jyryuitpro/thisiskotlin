package io.jyryuitpro.aop.part3.viewpagerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import io.jyryuitpro.aop.part3.viewpagerview.databinding.ActivityMainBinding
import io.jyryuitpro.aop.part3.viewpagerview.databinding.ItemViewpagerBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 데이터를 로드
//        val list = listOf<String>("월", "화", "수", "목", "금", "토", "일")
        val list = loadData()

        // 2. Adapter를 생성
//        val pagerAdapter = CustomPagerAdapter(list)
        val pagerAdapter = CustomPagerAdapter(list)

        // 3. Adapter와 뷰페이저를 연결
        binding.viewPager.adapter = pagerAdapter

        // 4. 탭 타이틀 목록 생성 - 위의 데이터 사용
        val titles = listOf<String>("월", "화", "수", "목", "금", "토", "일")
        // 5. 탭레이아웃과 뷰페이저 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
//            tab.text = list.get(position)
            tab.text = titles.get(position)
        }.attach()
    }

    fun loadData(): List<Page> {
        val pageList = mutableListOf<Page>()

        pageList.add(Page(1, "흐림"))
        pageList.add(Page(2, "맑음"))
        pageList.add(Page(3, "구름"))
        pageList.add(Page(4, "비"))
        pageList.add(Page(5, "눈"))
        pageList.add(Page(6, "태풍"))
        pageList.add(Page(7, "안개"))

        return pageList
    }
}

//class CustomPag개rAdapter(val textList: List<String>) : RecyclerView.Adapter<CustomPagerAdapter.Holder>() {
class CustomPagerAdapter(val pageList: List<Page>) : RecyclerView.Adapter<CustomPagerAdapter.Holder>() {

    class Holder(val binding: ItemViewpagerBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun setItem(text: String) {
//            binding.textView.text = text
//        }
        fun setItem(page: Page) {
            with(binding) {
                textDay.text = "${page.day} 일"
                textWeather.text = page.weather
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
//        holder.setItem(textList.get(position))
        holder.setItem(pageList.get(position))
    }

//    override fun getItemCount() = textList.size
    override fun getItemCount() = pageList.size
}

data class Page(val day: Int, val weather: String)
