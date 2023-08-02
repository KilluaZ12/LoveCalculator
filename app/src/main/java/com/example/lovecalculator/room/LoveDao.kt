package com.example.lovecalculator.room

import androidx.room.Dao
import androidx.room.Insert
import com.example.lovecalculator.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @androidx.room.Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>
}