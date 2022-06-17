package com.example.uas_ppbl.presentation.depedencyinjection

import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.presentation.adapter.BrandsAdapter
import com.example.uas_ppbl.presentation.adapter.DeviceAdapter
import com.example.uas_ppbl.presentation.adapter.LatestAdapter
import com.example.uas_ppbl.presentation.adapter.SearchAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AdapterModule {
    @Singleton
    @Provides
    fun provideBrandsAdapter() : BrandsAdapter{
        return BrandsAdapter()
    }
    @Singleton
    @Provides
    fun provideDeviceAdapter() : DeviceAdapter{
        return DeviceAdapter()
    }

    @Singleton
    @Provides
    fun provideSearchAdapter() : SearchAdapter{
        return SearchAdapter()
    }
    @Singleton
    @Provides
    fun provideLatestAdapter() : LatestAdapter{
        return LatestAdapter()
    }
}