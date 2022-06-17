//package com.example.uas_ppbl.data.repository.device.datasourceImpl
//
//import com.example.uas_ppbl.data.dao.DeviceDAO
//import com.example.uas_ppbl.data.model.device.Device
//import com.example.uas_ppbl.data.model.device.Phone
//import com.example.uas_ppbl.data.repository.device.datasource.DeviceLocalDataSource
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class DeviceLocalDataSourceImpl(
//    private val deviceDAO: DeviceDAO
//) : DeviceLocalDataSource{
//    override suspend fun getDevicesFromDB(): List<Phone> {
//        return deviceDAO.getListDevice()
//    }
//
//    override suspend fun saveDevicesToDB(device: List<Device>) {
//        CoroutineScope(Dispatchers.IO).launch {
//            deviceDAO.saveDevice(device)
//        }
//    }
//
//    override suspend fun clearAll() {
//        CoroutineScope(Dispatchers.IO).launch {
//            deviceDAO.deleteDevice()
//        }
//    }
//}