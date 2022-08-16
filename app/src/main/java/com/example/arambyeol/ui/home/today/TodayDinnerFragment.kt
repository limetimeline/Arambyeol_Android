package com.example.arambyeol.ui.home.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.arambyeol.databinding.PageTodayDinnerBinding


class TodayDinnerFragment : Fragment() {
    private var _binding: PageTodayDinnerBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val _text = MutableLiveData<String>().apply {
            value = "오늘의 저녁"
        }
        val text: LiveData<String> = _text

        _binding = PageTodayDinnerBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTodayDinner
        text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}