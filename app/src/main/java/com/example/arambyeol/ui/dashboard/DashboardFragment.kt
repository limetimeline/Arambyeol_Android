package com.example.arambyeol.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.arambyeol.databinding.FragmentDashboardBinding
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        val viewBoard = binding.board
        val list = ArrayList<BoardData>()
        list.add(BoardData("1", "name 1"))
        list.add(BoardData("2", "name 2"))
        list.add(BoardData("3", "name 3"))
        list.add(BoardData("4", "name 4"))
        list.add(BoardData("5", "name 5"))
        list.add(BoardData("6", "name 6"))
        list.add(BoardData("7", "name 7"))
        list.add(BoardData("8", "name 8"))
        list.add(BoardData("9", "name 9"))
        list.add(BoardData("10", "name 10"))
        list.add(BoardData("11", "name 11"))
        list.add(BoardData("12", "name 12"))


        val adapter = RecyclerUserAdapter(list)
        viewBoard.adapter = adapter


//        val list = ArrayList<BoardData>()
//        list.add(BoardData("1", "name 1"))
//        list.add(BoardData("2", "name 2"))
//        list.add(BoardData("3", "name 3"))
//
//        val adapter = RecyclerUserAdapter(list)
//        board.adapter = adapter




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}