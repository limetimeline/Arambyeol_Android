package com.example.arambyeol.ui.home.tomorrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.arambyeol.databinding.PageTomorrowLunchBinding



class TomorrowLunchFragment: Fragment() {
    private var _binding: PageTomorrowLunchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val _text = MutableLiveData<String>().apply {
            value = "내일의 점심"
        }
        val text: LiveData<String> = _text

        _binding = PageTomorrowLunchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textTomorrowLunch
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