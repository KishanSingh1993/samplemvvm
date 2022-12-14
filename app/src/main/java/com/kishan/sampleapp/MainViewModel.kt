package com.kishan.sampleapp

import android.util.Patterns
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val panNo = MutableLiveData<String>()
    val etDate = MutableLiveData<String>()
    val etMonth = MutableLiveData<String>()
    val etYear = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()


        val message : LiveData<Event<String>>
        get() = statusMessage

    fun showToastMessage(){

        if (panNo.value == null) {
            statusMessage.value = Event("Please enter PAN No.")
        }
        else if (panNo.value!! < 10.toString()){
            statusMessage.value = Event("Please enter A valid PAN No.")
        }
        else if (etDate.value == null) {
            statusMessage.value = Event("Please enter a date")
        } else if (etMonth.value == null){

            statusMessage.value = Event("Please enter a month")
        }else if (etYear.value == null){

            statusMessage.value = Event("Please enter a year")
        }
    }
}