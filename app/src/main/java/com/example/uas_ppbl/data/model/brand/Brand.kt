package com.example.uas_ppbl.data.model.brand


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "brand_list")
data class Brand(
    @PrimaryKey
    @SerializedName("brand_id")
    val brandId: Int?,
    @SerializedName("brand_name")
    val brandName: String?,
    @SerializedName("brand_slug")
    val brandSlug: String?,
    @SerializedName("detail")
    val detail: String?,
    @SerializedName("device_count")
    val deviceCount: Int?
):Serializable
