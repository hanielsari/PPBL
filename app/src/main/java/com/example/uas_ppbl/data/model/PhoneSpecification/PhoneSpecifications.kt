package com.example.uas_ppbl.data.model.PhoneSpecification


import com.google.gson.annotations.SerializedName

data class PhoneSpecifications(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Boolean?
)