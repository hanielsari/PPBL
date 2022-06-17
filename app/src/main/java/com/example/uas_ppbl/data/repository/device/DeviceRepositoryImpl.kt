//package com.example.uas_ppbl.data.repository.device
//
//import android.util.Log
//import com.example.uas_ppbl.data.model.brand.Brand
//import com.example.uas_ppbl.data.model.device.Device
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceCacheDataSource
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceLocalDataSource
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceRemoteDataSource
//import com.example.uas_ppbl.domain.repository.DeviceRepository
//
//class DeviceRepositoryImpl(
//    private val deviceRemoteDataSource: DeviceRemoteDataSource,
//    private val deviceLocalDataSource: DeviceLocalDataSource,
//    private val deviceCacheDataSource: DeviceCacheDataSource
//) : DeviceRepository {
//    override suspend fun getListDevice(): List<Device> {
//        return getBrandsFromCache()
//    }
//
//    suspend fun getDevicesFromAPI(): List<Device> {
//        lateinit var deviceList: List<Device>
//        try {
//            val response = deviceRemoteDataSource.getDevices()
//            val body = response.body()
//            if (body!=null){
//                deviceList = body.device!!
//            }
//        } catch (e: Exception) {
//            Log.i("TAG", e.message.toString())
//        }
//        return deviceList
//    }
//
//    suspend fun getBrandsFromDB(): List<Brand> {
//        lateinit var brandList: List<Brand>
//        try {
//            brandList = brandLocalDataSource.getBrandsFromDB()
//
//        } catch (e: Exception) {
//            Log.i("TAG", e.message.toString())
//        }
//        if(brandList.isEmpty()){
//            return brandList
//        }else{
//            brandList = getBrandsFromAPI()
//            brandLocalDataSource.saveBrandsToDB(brandList)
//        }
//        return brandList
//    }
//
//    suspend fun getBrandsFromCache(): List<Brand> {
//        lateinit var brandList: List<Brand>
//        try {
//            brandList = brandCacheDataSource.getBrandsFromCache()
//        } catch (e: Exception) {
//            Log.i("TAG", e.message.toString())
//        }
//        if (brandList.isNotEmpty()){
//            return brandList
//        }else{
//            brandList=getBrandsFromDB()
//            brandCacheDataSource.saveBrandsToCache(brandList)
//        }
//        return brandList
//    }
//}