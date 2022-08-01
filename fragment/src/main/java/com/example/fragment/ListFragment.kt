package com.example.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragment.databinding.FragmentListBinding

class ListFragment : Fragment() {

    lateinit var binding: FragmentListBinding
    lateinit var mainActivity: MainActivity

    // context에는 나를 삽입한 Activity가 담겨있습니다. 따라서 MainActivity가 담겨있습니다.
    // 프래그먼트가 메인 액티비티에 삽입되는 순간 안드로이드가 호출해줍니다. 그 순간 context가 넘어옵니다.
    override fun onAttach(context: Context) {
        super.onAttach(context)

        // MainActivity인지 검사 가능
        if (context is MainActivity) mainActivity = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // container: 부모 뷰
        binding = FragmentListBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_list, container, false)
        return binding.root
    }

    // 생명주기 함수 중 하나 : 바인딩만 연결하면 여기서도 가능
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 액티비티에서 전달받은 값을 프래그먼트에서 사용하는 방법
        // nullable일 경우는 with를 사용할 수 없습니다.
        with(binding) {
            arguments?.apply {
                textTitle.text = getString("key1")
                textValue.text = "${getInt("key2")}"
            }

            btnNext.setOnClickListener {
                // fragment_detail.xml의 배경이 투명하면 겹쳐보입니다.
                // 또한 android:clickable="true" 속성을 지정해야 crash 나지 않습니다.
                mainActivity.goDetail()
            }
        }
    }

    fun setValue(value: String) {
        binding.textFromActivity.text = value
    }
}