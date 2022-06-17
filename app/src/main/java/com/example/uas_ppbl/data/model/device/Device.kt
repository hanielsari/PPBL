package com.example.uas_ppbl.data.model.device


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


data class Device(
//    @PrimaryKey(autoGenerate = true)
//    val id:Int? = null,
//    @SerializedName("current_page")
//    val currentPage: Int?,
//    @SerializedName("last_page")
//    val lastPage: Int?,
    @SerializedName("phones")
    val phones: List<Phone>?,
//    @SerializedName("title")
//    val title: String?
)