package com.example.uas_ppbl.data.model.tophandphone


import com.google.gson.annotations.SerializedName

data class TopHandphone(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("status")
    val status: Boolean?
)