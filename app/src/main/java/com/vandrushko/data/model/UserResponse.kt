package com.vandrushko.data.model

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("code") var code: Int? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: User? = User()
)
