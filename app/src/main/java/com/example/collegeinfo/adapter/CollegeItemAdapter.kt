package com.example.collegeinfo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.collegeinfo.databinding.CollegeListItemBinding
import com.example.collegeinfo.model.College

class CollegeItemAdapter(private val onItemClicked: (College) -> Unit):
    ListAdapter<College, CollegeItemAdapter.CollegeViewHolder>(DiffCallback){

    private lateinit var context: Context

    class CollegeViewHolder(private var binding: CollegeListItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(college: College, context: Context){
            binding.collegeName.text = college.name
            binding.collegeEstablishedYear.text = context.getString(college.establishedYear!!)
            binding.collegeLocation.text = college.location
            Glide.with(context).load(college.logo).into(binding.collegeLogo)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CollegeViewHolder {
        context = parent.context
        return CollegeViewHolder(
            CollegeListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CollegeViewHolder, position: Int) {
        val current = getItem(position)
        holder.itemView.setOnClickListener {
            onItemClicked(current)
        }
        holder.bind(current,context)
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<College>() {
            override fun areItemsTheSame(oldItem: College, newItem: College): Boolean {
                return (
                        oldItem.name == newItem.name ||
                        oldItem.establishedYear == newItem.establishedYear ||
                        oldItem.detail == newItem.detail
                        )
            }
            override fun areContentsTheSame(oldItem: College, newItem: College): Boolean {
                return oldItem == newItem
            }
        }
    }

}