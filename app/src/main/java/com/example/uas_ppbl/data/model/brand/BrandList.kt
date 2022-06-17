package com.example.uas_ppbl.data.model.brand


import com.google.gson.annotations.SerializedName

data class BrandList(
    @SerializedName("data")
    val data: List<Brand>?,
//    @SerializedName("status")
//    val status: Boolean?
)