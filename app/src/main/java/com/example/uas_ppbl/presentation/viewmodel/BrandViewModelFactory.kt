//package com.example.uas_ppbl.presentation.viewmodel
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.uas_ppbl.domain.usecase.GetBrandUseCase
//import com.example.uas_ppbl.domain.usecase.GetDeviceUseCase
//
//
//class BrandViewModelFactory(
//    private val getBrandUseCase : GetBrandUseCase,
//    private val getDeviceUseCase: GetDeviceUseCase
//
//):ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//       return BrandViewModel(getBrandUseCase,getDeviceUseCase) as T
//    }
//
//}