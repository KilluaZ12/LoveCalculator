package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.room.LoveDao
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: LoveApi,
    private val dao: LoveDao
) {

    fun getAllData() = dao.getAllDataAlphabetically()
    fun getPercentage(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getPercentage(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                liveData.postValue(response.body())
                dao.insert(response.body()!!)
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                liveData.postValue(LoveModel(error = t.message))
            }

        })

        return liveData
    }

}