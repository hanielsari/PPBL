package com.example.uas_ppbl.data.model.PhoneSpecification


import com.google.gson.annotations.SerializedName

data class Specification(
    @SerializedName("specs")
    val specs: List<Spec>?,
    @SerializedName("title")
    val title: String?
)