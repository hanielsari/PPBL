package com.example.uas_ppbl.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.uas_ppbl.data.model.Search.PhoneDataResponse
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.latest.Latest
import com.example.uas_ppbl.data.model.tophandphone.TopHandphone
import com.example.uas_ppbl.data.util.Resource
import com.example.uas_ppbl.domain.usecase.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BrandViewModel @ViewModelInject constructor(
    private val getBrandUseCase: GetBrandUseCase,
    private val getDeviceUseCase: GetDeviceUseCase,
    private val getSearchDeviceUseCase: GetSearchDeviceUseCase,
    private val getLatestDeviceUseCase: GetLatestDeviceUseCase,
    private val getTopHandphoneUseCase: GetTopHandphoneUseCase
) : ViewModel() {

    val getBrand: MutableLiveData<Resource<BrandList>> = MutableLiveData()
    val getDevice: MutableLiveData<Resource<DeviceList>> = MutableLiveData()
    val getLatest: MutableLiveData<Resource<Latest>> = MutableLiveData()
    val getTopHandphone: MutableLiveData<Resource<TopHandphone>> = MutableLiveData()



    fun getListBrand() = viewModelScope.launch(Dispatchers.IO) {
        getBrand.postValue(Resource.Loading())
        try {
            val apiResult = getBrandUseCase.execute()
            getBrand.postValue(apiResult)
        } catch (e: Exception) {
            getBrand.postValue(Resource.Error(e.message))
        }

    }

    fun getListDevice(brandSlug: String, page: Int) = viewModelScope.launch(Dispatchers.IO) {
        getDevice.postValue(Resource.Loading())
        try {
            val apiResult = getDeviceUseCase.execute(brandSlug, page)
            getDevice.postValue(apiResult)
        } catch (e: Exception) {
            getDevice.postValue(Resource.Error(e.message))
        }
    }

    fun getLatestsDevice() = viewModelScope.launch(Dispatchers.IO) {
        getLatest.postValue(Resource.Loading())
        try {
            val apiResult = getLatestDeviceUseCase.execute()
            getLatest.postValue(apiResult)
        } catch (e: Exception) {
            getLatest.postValue(Resource.Error(e.message))
        }
    }
    fun getTopHandpone() = viewModelScope.launch(Dispatchers.IO) {
        getTopHandphone.postValue(Resource.Loading())
        try {
            val apiResult = getLatestDeviceUseCase.execute()
            getLatest.postValue(apiResult)
        } catch (e: Exception) {
            getLatest.postValue(Resource.Error(e.message))
        }
    }
    val getSearch: MutableLiveData<Resource<Search>> = MutableLiveData()
    fun getSearchDevice(querySearch: String) =
        viewModelScope.launch(Dispatchers.IO) {
            getSearch.postValue(Resource.Loading())
            try {
                val apiResult = getSearchDeviceUseCase.execute(querySearch)
                getSearch.postValue(apiResult)
            } catch (e: Exception) {
                getSearch.postValue(Resource.Error(e.message))
            }
        }
}
