package com.example.uas_ppbl.data.model.device


import com.example.uas_ppbl.data.model.brand.Brand
import com.google.gson.annotations.SerializedName

data class DeviceList(
    @SerializedName("data")
    val device: Device?,
//    val device: List<Device>?,
    @SerializedName("status")
    val status: Boolean?
)