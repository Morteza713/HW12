package com.example.movieapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelProfile:ViewModel() {

        var FillData = MutableLiveData<Boolean>()

        fun setFillData(flag:Boolean):Boolean{
            return if (flag){
                FillData.value = true
                true
            }else{
                FillData.value = false
                false
            }
        }
    init {
        FillData.value = false
    }

}