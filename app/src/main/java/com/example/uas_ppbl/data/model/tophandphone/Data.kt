package com.example.uas_ppbl.data.model.tophandphone


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("phones")
    val phones: List<Phone>?,
    @SerializedName("title")
    val title: String?
)