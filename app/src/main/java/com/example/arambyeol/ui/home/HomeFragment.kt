package com.example.arambyeol.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.arambyeol.R
import com.example.arambyeol.databinding.FragmentHomeBinding
import com.example.arambyeol.ui.home.aftertomorrow.AfterTomorrowDinnerFragment
import com.example.arambyeol.ui.home.aftertomorrow.AfterTomorrowLunchFragment
import com.example.arambyeol.ui.home.aftertomorrow.AfterTomorrowMorningFragment
import com.example.arambyeol.ui.home.today.TodayDinnerFragment
import com.example.arambyeol.ui.home.today.TodayLunchFragment
import com.example.arambyeol.ui.home.today.TodayMorningFragment
import com.example.arambyeol.ui.home.tomorrow.TomorrowDinnerFragment
import com.example.arambyeol.ui.home.tomorrow.TomorrowLunchFragment
import com.example.arambyeol.ui.home.tomorrow.TomorrowMorningFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        todayMenu()
        tomorrowMenu()
        afterTomorrowMenu()



        return root
    }

    private fun todayMenu(){
        val viewPagerToday = binding.viewPagerToday
        //viewPagerToday.adapter = ViewPagerAdapter(this) // 어댑터 생성

        val adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(TodayMorningFragment())
        adapter.addFragment(TodayLunchFragment())
        adapter.addFragment(TodayDinnerFragment())
        viewPagerToday.adapter = adapter
        viewPagerToday.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position + 1}")
            }
        })

        //  indicator
        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                indicator0_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.shape_circle_white))
                indicator1_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))
                indicator2_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))

                when(p0){
                    0 -> indicator0_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    1 -> indicator1_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    2 -> indicator2_iv_main_today.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                }
            }
        })

    }

    private fun tomorrowMenu(){
        val viewPagerToday = binding.viewPagerTomorrow
        //viewPagerToday.adapter = ViewPagerAdapter(this) // 어댑터 생성

        val adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(TomorrowMorningFragment())
        adapter.addFragment(TomorrowLunchFragment())
        adapter.addFragment(TomorrowDinnerFragment())
        viewPagerToday.adapter = adapter
        viewPagerToday.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position + 1}")
            }
        })

        //  indicator
        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                indicator0_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.shape_circle_white))
                indicator1_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))
                indicator2_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))

                when(p0){
                    0 -> indicator0_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    1 -> indicator1_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    2 -> indicator2_iv_main_tomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                }
            }
        })
    }

    private fun afterTomorrowMenu(){
        val viewPagerToday = binding.viewPagerAftertomorrow
        //viewPagerToday.adapter = ViewPagerAdapter(this) // 어댑터 생성

        val adapter = ViewPagerAdapter(requireActivity())
        adapter.addFragment(AfterTomorrowMorningFragment())
        adapter.addFragment(AfterTomorrowLunchFragment())
        adapter.addFragment(AfterTomorrowDinnerFragment())
        viewPagerToday.adapter = adapter
        viewPagerToday.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로

        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position + 1}")
            }
        })

        //  indicator
        viewPagerToday.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                indicator0_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.shape_circle_white))
                indicator1_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))
                indicator2_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_white))

                when(p0){
                    0 -> indicator0_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    1 -> indicator1_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                    2 -> indicator2_iv_main_aftertomorrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.shape_circle_yellow))
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}

