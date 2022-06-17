package com.example.uas_ppbl.presentation.depedencyinjection

import com.example.uas_ppbl.data.repository.BrandRepositoryImpl
import com.example.uas_ppbl.data.repository.datasource.BrandRemoteDataSource
import com.example.uas_ppbl.domain.repository.BrandRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideBrandRepository(brandRemoteDataSource: BrandRemoteDataSource):BrandRepository{
        return BrandRepositoryImpl(brandRemoteDataSource)
    }
}