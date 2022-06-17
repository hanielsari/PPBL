//package com.example.uas_ppbl.data.repository.device.datasourceImpl
//
//import com.example.uas_ppbl.data.model.device.Phone
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceCacheDataSource
//
//class DeviceCacheDataSourceImpl : DeviceCacheDataSource {
//    private var deviceList = ArrayList<Phone>()
//
//    override suspend fun getDevicesFromCache(): List<Phone> {
//        return deviceList
//    }
//
//    override suspend fun saveDevicesToCache(devices: List<Phone>) {
//        deviceList.clear()
//        deviceList = ArrayList(devices)
//    }
//}