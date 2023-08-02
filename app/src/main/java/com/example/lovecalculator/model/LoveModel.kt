package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "love_table")
data class LoveModel(
    @SerializedName("fname")
    var firstName: String? = null,
    @SerializedName("sname")
    var secondName: String? = null,
    var percentage: String? = null,
    var result: String? = null,
    var error: String? = null,
    @PrimaryKey(autoGenerate = true)
    var id: Int?= null
) : java.io.Serializable