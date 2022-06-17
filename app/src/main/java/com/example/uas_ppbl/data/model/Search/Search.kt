package com.example.uas_ppbl.data.model.Search


import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("data")
    val `data`: PhoneDataResponse?,
    @SerializedName("status")
    val status: Boolean?
)