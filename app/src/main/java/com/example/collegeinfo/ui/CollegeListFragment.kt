package com.example.collegeinfo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.collegeinfo.R
import com.example.collegeinfo.adapter.CollegeItemAdapter
import com.example.collegeinfo.model.CollegeViewModel
import com.example.collegeinfo.databinding.FragmentCollegeListBinding

class CollegeListFragment : Fragment() {

    private val collegeViewModel: CollegeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentCollegeListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCollegeListBinding.bind(view)
        val adapter = CollegeItemAdapter{
            collegeViewModel.updateCurrentCollege(it)
            this.findNavController().navigate(R.id.action_collegeListFragment_to_collegeDetailFragment)
        }
        binding.collegeListRv.adapter = adapter
        adapter.submitList(collegeViewModel.collegeList)
    }
}