package com.example.collegeinfo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.collegeinfo.databinding.FragmentCollegeDetailBinding
import com.example.collegeinfo.model.CollegeViewModel

class CollegeDetailFragment : Fragment() {

    private val sharedCollegeViewModel: CollegeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentCollegeDetailBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentCollegeDetailBinding.bind(view)
        sharedCollegeViewModel.currentCollegeItem.observe(this.viewLifecycleOwner){
            binding.collegeName.text = it.name
            Glide.with(this).load(it.photo).into(binding.collegePhoto)
            binding.collegeDetail.text = it.detail
        }
    }
}

