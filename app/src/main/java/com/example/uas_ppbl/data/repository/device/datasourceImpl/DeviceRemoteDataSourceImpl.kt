//package com.example.uas_ppbl.data.repository.device.datasourceImpl
//
//import com.example.praktikumnewshilt.api.HandphoneService
//import com.example.uas_ppbl.data.model.device.DeviceList
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceRemoteDataSource
//import retrofit2.Response
//
//class DeviceRemoteDataSourceImpl(
//    private val phoneService: HandphoneService
//) : DeviceRemoteDataSource {
//
//    override suspend fun getDevices(): Response<DeviceList> {
//        return phoneService.getListDevice()
//    }
//}