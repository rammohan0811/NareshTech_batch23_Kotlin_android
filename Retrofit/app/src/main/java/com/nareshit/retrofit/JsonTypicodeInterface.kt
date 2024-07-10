package com.nareshit.retrofit

import retrofit2.Call
import retrofit2.http.GET

// TODO 4
interface JsonTypicodeInterface {

    @GET("posts/1")
    fun getData(): Call<FakeGet>
}