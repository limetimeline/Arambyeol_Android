package com.example.arambyeol.ui.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter



class ViewPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa){
    var fragments : ArrayList<Fragment> = ArrayList() // 프래그먼트가 저장될 배열

    override fun getItemCount(): Int {
        return fragments.size

    } // 프래그먼트 배열의 크기

    override fun createFragment(position: Int): Fragment {
        return fragments[position] // 반환될 프래그먼트
   }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size-1)
    }

    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }

}

