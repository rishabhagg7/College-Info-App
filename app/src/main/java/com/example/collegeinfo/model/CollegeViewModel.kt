package com.example.collegeinfo.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.collegeinfo.data.CollegeData
import com.example.collegeinfo.data.CollegeData.getCollegeData

class CollegeViewModel: ViewModel() {
//    private var _currentCollegeItem: MutableLiveData<CollegeItem> = MutableLiveData<CollegeItem>()
//    val currentCollegeItem: LiveData<CollegeItem>
//        get() = _currentCollegeItem
//
//    private var _collegeList: ArrayList<CollegeItem> = ArrayList()
//    val collegeList: ArrayList<CollegeItem>
//        get() = _collegeList
//
//    init {
//        _collegeList = CollegeData.getCollegeData()
//        _currentCollegeItem.value = collegeList[0]
//    }
//
//    fun updateCurrentCollege(collegeItem: CollegeItem){
//        _currentCollegeItem.value = collegeItem
//    }
    private var _currentCollege: MutableLiveData<College> = MutableLiveData <College>()
    val currentCollegeItem: LiveData<College>
        get() = _currentCollege

    private var _collegeList: ArrayList<College> = ArrayList()
    val collegeList: ArrayList<College>
        get() = _collegeList

    init {
//        CollegeData.setCollegeData()
//        _collegeList = CollegeData.getCollegeData()
        fetchCollegeData()
    }

    fun updateCurrentCollege(college: College){
        _currentCollege.value = college
    }

    private fun fetchCollegeData(){
        getCollegeData(object: CollegeData.CollegeDataCallBack {
            override fun onCollegeDataRecieved(collegeData: ArrayList<College>) {
                _collegeList = collegeData
                _currentCollege.value = collegeList[0]
                Log.d("GettingData","${_currentCollege.value!!.name}")
            }
        })
    }
}

