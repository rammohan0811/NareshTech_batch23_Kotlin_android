package com.nareshit.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

// TODO 4
interface JsonTypicodeInterface {

    @GET("posts/1")
    fun getData(): Call<FakeGet>

    @POST("posts")
    fun postData(@Body postRequest: PostRequest):Call<PostResponse>
}