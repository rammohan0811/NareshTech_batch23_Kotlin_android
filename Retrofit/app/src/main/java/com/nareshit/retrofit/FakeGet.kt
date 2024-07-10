package com.nareshit.retrofit

import com.google.gson.annotations.SerializedName
import java.io.Serial
// TODO 3
data class FakeGet(
    @SerializedName("userId") var userId:Int? = null,
    @SerializedName("id") var id:Int? = null,
    @SerializedName("title") var title:String? = null,
    @SerializedName("body") var body:String? = null
)
