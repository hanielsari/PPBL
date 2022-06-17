package com.example.uas_ppbl.data.model.Search

import com.google.gson.annotations.SerializedName

data class PhoneDataResponse (
    @SerializedName("phones")
    val phones: List<Data>?,
//    @SerializedName("title")
//    val title: String,
)