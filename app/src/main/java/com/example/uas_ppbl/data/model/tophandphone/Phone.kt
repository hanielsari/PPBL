package com.example.uas_ppbl.data.model.tophandphone


import com.google.gson.annotations.SerializedName

data class Phone(
    @SerializedName("detail")
    val detail: String?,
    @SerializedName("phone_name")
    val phoneName: String?,
    @SerializedName("slug")
    val slug: String?
)