package com.zen.composewaifus.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val  BASE_URL = "https://api.waifu.im/"
    fun getWaifuService(): WaifuService {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(WaifuService::class.java)
    }
}