package com.example.uas_ppbl.presentation.depedencyinjection

import com.example.uas_ppbl.domain.repository.BrandRepository
import com.example.uas_ppbl.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class UseCaseModule {
    @Singleton
    @Provides
    fun provideGetListBrandUseCase(brandRepository: BrandRepository) : GetBrandUseCase {
        return GetBrandUseCase(brandRepository)
    }
    @Singleton
    @Provides
    fun provideGetListDeviceUseCase(brandRepository: BrandRepository) : GetDeviceUseCase{
        return GetDeviceUseCase(brandRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedDeviceUseCase(brandRepository: BrandRepository) : GetSearchDeviceUseCase{
        return GetSearchDeviceUseCase(brandRepository)
    }

    @Singleton
    @Provides
    fun provideGetLatestDeviceUseCase(brandRepository: BrandRepository) : GetLatestDeviceUseCase{
        return GetLatestDeviceUseCase(brandRepository)
    }
    @Singleton
    @Provides
    fun provideGetTopHandphone(brandRepository: BrandRepository) : GetTopHandphoneUseCase {
        return GetTopHandphoneUseCase(brandRepository)
    }
}