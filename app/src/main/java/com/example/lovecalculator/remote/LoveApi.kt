package com.example.lovecalculator.remote

import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "f9468536bcmsha61c49514b16d75p1fbd05jsn8076c2d94f07",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"

    ): Call<LoveModel>
}