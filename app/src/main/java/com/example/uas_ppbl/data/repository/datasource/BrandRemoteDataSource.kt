package com.example.uas_ppbl.data.repository.datasource

import com.example.uas_ppbl.data.model.PhoneSpecification.PhoneSpecifications
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.Device
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.model.latest.Latest
import retrofit2.Response

interface BrandRemoteDataSource {
    suspend fun getListBrand(): Response<BrandList>
    suspend fun getListDevice(brandSlug : String, page: Int): Response<DeviceList>
    suspend fun getSearchDevice(searchQuery : String): Response<Search>
    suspend fun getlatest(): Response<Latest>
}