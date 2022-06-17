package com.example.uas_ppbl.data.model.Search


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("brand")
    val brand: String?,
//    @SerializedName("dimension")
//    val dimension: String?,
//    @SerializedName("os")
//    val os: String?,
    @SerializedName("phone_images")
    val phoneImages: List<String>?,
    @SerializedName("phone_name")
    val phoneName: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
//    @SerializedName("specifications")
//    val specifications: List<Specification>?,
    @SerializedName("storage")
    val storage: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
)