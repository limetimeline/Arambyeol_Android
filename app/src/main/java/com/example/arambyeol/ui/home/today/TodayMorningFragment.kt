package com.example.arambyeol.ui.home.today

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.arambyeol.databinding.PageTodayMorningBinding



class TodayMorningFragment: Fragment() {
    private var _binding: PageTodayMorningBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val _text = MutableLiveData<String>().apply {
            value = "오늘의 아침"
        }
        val text: LiveData<String> = _text

        _binding = PageTodayMorningBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTodayMorning
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