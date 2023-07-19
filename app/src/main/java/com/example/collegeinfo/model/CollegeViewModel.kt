package com.example.collegeinfo.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.collegeinfo.data.CollegeData.getCollegeData
import kotlinx.coroutines.launch

class CollegeViewModel: ViewModel() {
    private var _currentCollege: MutableLiveData<College> = MutableLiveData <College>()
    val currentCollegeItem: LiveData<College>
        get() = _currentCollege

    private var _collegeList: ArrayList<College> = ArrayList()
    val collegeList: ArrayList<College>
        get() = _collegeList

    init {
//        CollegeData.setCollegeData()
        viewModelScope.launch{
            _collegeList = getCollegeData()
        }
    }

    fun updateCurrentCollege(college: College){
        _currentCollege.value = college
    }
}

