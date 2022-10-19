package com.example.mvvmjson.Network

import com.example.mvvmjson.Model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("marvel")
    fun getMovieList(): Call<MutableList<MovieModel>>
}