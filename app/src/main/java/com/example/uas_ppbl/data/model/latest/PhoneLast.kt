package com.example.uas_ppbl.data.model.latest


import com.google.gson.annotations.SerializedName

data class PhoneLast(
    @SerializedName("detail")
    val detail: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("phone_name")
    val phoneName: String?,
    @SerializedName("slug")
    val slug: String?
)