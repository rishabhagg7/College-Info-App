package com.example.collegeinfo.model

import com.example.collegeinfo.R

data class CollegeItem(
    val id: Int,
    val collegeNameId: Int,
    val collegeEstablishedYear : Int,
    val collegeLogoId: Int,
    val collegePhotoId: Int,
    val collegeLocationId: Int,
    val collegeDetailsId: Int = R.string.college_detail_text
)
