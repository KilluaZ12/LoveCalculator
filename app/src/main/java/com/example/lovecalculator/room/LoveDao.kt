package com.example.lovecalculator.room

import androidx.room.*
import com.example.lovecalculator.model.LoveModel


@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)

    @androidx.room.Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>

    @Query("SELECT * FROM love_table ORDER BY firstName ASC")
    fun getAllDataAlphabetically(): List<LoveModel>

}