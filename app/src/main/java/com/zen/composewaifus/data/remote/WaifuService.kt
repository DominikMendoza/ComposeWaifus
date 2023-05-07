package com.zen.composewaifus.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface WaifuService {
    @GET("search")
    fun fetchWaifus(): Call<WaifuResponse>
}