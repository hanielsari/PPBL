package com.example.uas_ppbl.data.repository.datasourceImpl

import com.example.praktikumnewshilt.api.HandphoneService
import com.example.uas_ppbl.data.model.PhoneSpecification.PhoneSpecifications
import com.example.uas_ppbl.data.model.Search.PhoneDataResponse
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.Device
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.model.latest.Latest
import com.example.uas_ppbl.data.model.tophandphone.TopHandphone
import com.example.uas_ppbl.data.repository.datasource.BrandRemoteDataSource
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.domain.repository.BrandRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class BrandRemoteDataSourceImpl(
    private val handphoneService: HandphoneService
) : BrandRemoteDataSource {

    override suspend fun getListBrand(): Response<BrandList> {
        return handphoneService.getListBrand()
    }

    override suspend fun getTopHandphone(): Response<TopHandphone> {
        return handphoneService.getTopPhone()
    }

    override suspend fun getListDevice(brandSlug: String, page: Int): Response<DeviceList> {
        return handphoneService.getListDevice(brandSlug, page)
    }

    override suspend fun getSearchDevice(searchQuery: String): Response<Search> {
        return handphoneService.getSearchquery(searchQuery)
    }

    override suspend fun getlatest(): Response<Latest> {
        return handphoneService.getLatest()
    }


}