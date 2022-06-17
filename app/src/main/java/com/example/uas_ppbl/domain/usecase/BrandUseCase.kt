package com.example.uas_ppbl.domain.usecase

import com.example.uas_ppbl.data.model.PhoneSpecification.PhoneSpecifications
import com.example.uas_ppbl.data.model.Search.PhoneDataResponse
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.model.latest.Latest
import com.example.uas_ppbl.data.model.tophandphone.TopHandphone
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.domain.repository.BrandRepository
import kotlinx.coroutines.flow.Flow

class GetBrandUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(): Resource<BrandList> {
        return brandRepository.getListBrand()
    }
}

class GetDeviceUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(brandSlug: String, page: Int): Resource<DeviceList> {
        return brandRepository.getListDevice(brandSlug, page)
    }
}

class SaveDeviceUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(phone: Phone) = brandRepository.saveDevice(phone)
}

class GetSaveDeviceUseCase(private val brandRepository: BrandRepository) {
    fun execute(): Flow<List<Phone>> {
        return brandRepository.getSaveDevice()
    }
}

class DeleteSaveDeviceUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(phone: Phone) = brandRepository.deleteDevice(phone)
}

class GetSearchDeviceUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(searchQuery: String): Resource<Search> {
        return brandRepository.getSearchDevice(searchQuery)
    }
}
class GetLatestDeviceUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(): Resource<Latest> {
        return brandRepository.getLatest()
    }
}
class GetTopHandphoneUseCase(private val brandRepository: BrandRepository) {
    suspend fun execute(): Resource<TopHandphone> {
        return brandRepository.getToHandphone()
    }
}