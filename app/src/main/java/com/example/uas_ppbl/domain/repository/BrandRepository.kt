package com.example.uas_ppbl.domain.repository

import com.example.uas_ppbl.data.model.PhoneSpecification.PhoneSpecifications
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.Device
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.model.latest.Latest
import com.example.uas_ppbl.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface BrandRepository {
    suspend fun getListBrand() : Resource<BrandList>
    suspend fun getLatest() : Resource<Latest>
    suspend fun getListDevice(brandSlug : String, page: Int): Resource<DeviceList>
    suspend fun getSearchDevice(searchQuery : String): Resource<Search>
    suspend fun saveDevice(phone: Phone)
    suspend fun deleteDevice(phone: Phone)
    fun getSaveDevice() : Flow<List<Phone>>
}