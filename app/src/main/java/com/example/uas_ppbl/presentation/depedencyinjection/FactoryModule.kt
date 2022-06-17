//package com.example.uas_ppbl.presentation.depedencyinjection
//
//import com.example.uas_ppbl.domain.usecase.GetBrandUseCase
//import com.example.uas_ppbl.domain.usecase.GetDeviceUseCase
//import com.example.uas_ppbl.presentation.viewmodel.BrandViewModelFactory
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.components.ApplicationComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(ApplicationComponent::class)
//class FactoryModule {
//    @Singleton
//    @Provides
//    fun provideBrandViewModelFactory(
//        getBrandUseCase: GetBrandUseCase,
//        getDeviceUseCase: GetDeviceUseCase
//    ): BrandViewModelFactory {
//        return BrandViewModelFactory(getBrandUseCase,getDeviceUseCase)
//    }
//}