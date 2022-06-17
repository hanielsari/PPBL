package com.example.uas_ppbl.data.model.latest


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("phones")
    val phoneLasts: List<PhoneLast>?,
)