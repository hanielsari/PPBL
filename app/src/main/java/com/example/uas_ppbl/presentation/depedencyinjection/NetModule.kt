package com.example.uas_ppbl.presentation.di.core

import com.example.praktikumnewshilt.api.HandphoneService
import com.example.uas_ppbl.BuildConfig


import com.example.uas_ppbl.BuildConfig.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NetModule() {
    //pada module di butuhkan object yang akan di inject pada kelas lain

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            //converter gson melakukan convert gson di create jadi objek
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    // hasil dari provideRetrofit akan digunakan pada fungsi di bawah ini tanpa kita perlu melakukan import
    @Singleton
    @Provides
    fun provideHandphoneService(retrofit: Retrofit): HandphoneService {
        return retrofit.create(HandphoneService::class.java)
    }
}