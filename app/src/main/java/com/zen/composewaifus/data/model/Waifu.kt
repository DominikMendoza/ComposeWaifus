package com.zen.composewaifus.data.model

import com.google.gson.annotations.SerializedName

data class Waifu(
    @SerializedName("image_id")
    val id: String,
    @SerializedName("url")
    val url: String
)
