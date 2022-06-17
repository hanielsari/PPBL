package com.example.uas_ppbl.data.repository

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

class BrandRepositoryImpl (
    private val brandRemoteDataSource: BrandRemoteDataSource
): BrandRepository {
    private fun responseToResourceBrand(response: Response<BrandList>): Resource<BrandList> {
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    private fun responseToResourceDevice(response: Response<DeviceList>): Resource<DeviceList>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }

    private fun responseToResourceSearch(response: Response<Search>): Resource<Search>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    private fun responseToResourceLatest(response: Response<Latest>): Resource<Latest>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    private fun responseSpesification(response: Response<PhoneSpecifications>): Resource<PhoneSpecifications>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    private fun responseToTopHandphone(response: Response<TopHandphone>): Resource<TopHandphone>{
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(response.message())
    }
    override suspend fun getListBrand(): Resource<BrandList> {
        return responseToResourceBrand(brandRemoteDataSource.getListBrand())
    }

    override suspend fun getLatest(): Resource<Latest> {
        return responseToResourceLatest(brandRemoteDataSource.getlatest())
    }

    override suspend fun getListDevice(brandSlug: String, page: Int): Resource<DeviceList> {
        return responseToResourceDevice(brandRemoteDataSource.getListDevice(brandSlug,page))
    }

    override suspend fun getSearchDevice(searchQuery: String): Resource<Search> {
        return responseToResourceSearch(brandRemoteDataSource.getSearchDevice(searchQuery))
    }

    override suspend fun getToHandphone(): Resource<TopHandphone> {
        return responseToTopHandphone((brandRemoteDataSource.getTopHandphone()))
    }


    override suspend fun saveDevice(phone: Phone) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDevice(phone: Phone) {
        TODO("Not yet implemented")
    }

    override fun getSaveDevice(): Flow<List<Phone>> {
        TODO("Not yet implemented")
    }
}