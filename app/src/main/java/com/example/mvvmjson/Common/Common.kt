package com.example.mvvmjson.Common

import com.example.mvvmjson.Network.APIService
import com.example.mvvmjson.Network.Retrofit

object Common {
    private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val getAPIService: APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)

}