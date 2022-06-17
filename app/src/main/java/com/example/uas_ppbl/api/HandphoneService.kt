package com.example.praktikumnewshilt.api

import com.example.uas_ppbl.data.model.PhoneSpecification.PhoneSpecifications
import com.example.uas_ppbl.data.model.Search.PhoneDataResponse
import com.example.uas_ppbl.data.model.Search.Search
import com.example.uas_ppbl.data.model.brand.BrandList
import com.example.uas_ppbl.data.model.device.DeviceList
import com.example.uas_ppbl.data.model.latest.Latest
import com.example.uas_ppbl.data.model.tophandphone.TopHandphone
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HandphoneService {
    @GET("v2/brands")
    suspend fun getListBrand(
    ): Response<BrandList>

    @GET("v2/latest")
    suspend fun getLatest(
    ): Response<Latest>

    @GET("v2/top-by-interest")
    suspend fun getTopPhone(
    ): Response<TopHandphone>


    @GET("brands/{brandSlug}/{phoneSlug}")
    suspend fun getSpesificationHp(
        @Path("brandSlug") brandSlug: String,
        @Path("phoneSlug") phoneSlug: String
    ): Response<PhoneSpecifications>

    @GET("v2/brands/{brandSlug}")
    suspend fun getListDevice(
        @Path("brandSlug")
        brandSlug: String,
        @Query("current_page")
        page: Int,
    ): Response<DeviceList>

    @GET("v2/search")
    suspend fun getSearchquery(
        @Query("query")
        searchQuery: String,
    ): Response<Search>
}
