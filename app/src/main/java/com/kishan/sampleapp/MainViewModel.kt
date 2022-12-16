package com.kishan.sampleapp


import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*


class MainViewModel() : ViewModel() {

    val panNo = MutableLiveData<String>()
    val strDate = MutableLiveData<String>()
    val strMonth = MutableLiveData<String>()
    val strYear = MutableLiveData<String>()

    private val statusMessage = MutableLiveData<Event<String>>()


        val message : LiveData<Event<String>>
        get() = statusMessage

    fun showToastMessage(){

        if (panNo.value == null || panNo.value!!.length < 10) {
            statusMessage.value = Event("Please enter PAN No.")
        }
        else if (strDate.value == null) {
            statusMessage.value = Event("Please enter a date")
//            Log.i("Date", strDate.value.toString())


        } else if (strMonth.value == null){
            statusMessage.value = Event("Please enter a month")
        }else if (strYear.value == null){

            statusMessage.value = Event("Please enter a year")
        }
        else{

            if (strMonth.value!!.toString() == "02"){
                if (strDate.value.toString().toInt() > 29){
                    statusMessage.value = Event("Please enter a valid date")
                }
            }
            else{

                statusMessage.value = Event("Data Successfully Saved")
            }

        }

    }

    fun closeApp(){
        System.exit(0)
    }

    fun funBD(dateStr: String) {
        val formatter = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault())
        val date = formatter.parse(dateStr)
        println(date)
    }
}