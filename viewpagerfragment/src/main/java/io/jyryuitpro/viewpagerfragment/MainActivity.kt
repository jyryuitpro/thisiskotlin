package io.jyryuitpro.viewpagerfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import io.jyryuitpro.viewpagerfragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // 1. 페이지 데이터를 로드
        val list = listOf<Fragment>(FragmentA(), FragmentB(), FragmentC(), FragmentD())

        // 2. Adapter를 생성
        val pagerAdapter = FragmentPagerAdapter(list, this)

        with(binding) {
            // 3. Adapter와 뷰페이저 연결
            viewPager.adapter = pagerAdapter

            // 4. 탭 메뉴의 개수만큼 제목을 목록으로 생성
            val titles = listOf<String>("A", "B", "C", "D")

            // 5. 탭레이아웃과 뷰페이저 연결
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = titles.get(position)
            }.attach()
        }
    }
}

class FragmentPagerAdapter(val fragmentList: List<Fragment>, fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
//    override fun getItemCount(): Int {
//        return fragmentList.size
//    }

    override fun getItemCount() = fragmentList.size

//    override fun createFragment(position: Int): Fragment {
//        return fragmentList.get(position)
//    }

    override fun createFragment(position: Int) = fragmentList.get(position)
}