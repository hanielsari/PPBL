package com.example.uas_ppbl.data.model.device


import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "Phone")
data class Phone(
    @SerializedName("brand")
    val brand: String?,
    @SerializedName("detail")
    val detail: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("phone_name")
    val phoneName: String?,
    @SerializedName("slug")
    val slug: String?
):Serializable