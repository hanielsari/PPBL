package com.example.uas_ppbl.data.model.Search


import com.google.gson.annotations.SerializedName

data class Spec(
    @SerializedName("key")
    val key: String?,
    @SerializedName("val")
    val valX: List<String>?
)