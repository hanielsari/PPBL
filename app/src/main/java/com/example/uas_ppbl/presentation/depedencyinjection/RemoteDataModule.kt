package com.example.uas_ppbl.presentation.depedencyinjection

import com.example.praktikumnewshilt.api.HandphoneService
import com.example.uas_ppbl.data.repository.datasource.BrandRemoteDataSource
import com.example.uas_ppbl.data.repository.datasourceImpl.BrandRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideBrandRemoteDataResource(handphoneService: HandphoneService): BrandRemoteDataSource {
        return BrandRemoteDataSourceImpl(handphoneService)
    }
}