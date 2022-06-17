package com.example.uas_ppbl.data.model.latest


import com.google.gson.annotations.SerializedName

data class Latest(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Boolean?
)