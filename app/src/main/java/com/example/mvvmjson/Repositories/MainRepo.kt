package com.example.mvvmjson.Repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmjson.Common.Common
import com.example.mvvmjson.Model.MovieModel
import com.example.mvvmjson.Network.APIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepo {
    private val apiService: APIService

    companion object {
        private const val TAG = "MainRepo"
    }

    init {
        apiService = Common.getAPIService
    }

    val getMovieLiveData: MutableLiveData<MutableList<MovieModel>>
    get() {
        val data: MutableLiveData<MutableList<MovieModel>> =
            MutableLiveData<MutableList<MovieModel>>()
        apiService.getMovieList().enqueue(object : Callback<MutableList<MovieModel>>
        {
            override fun onResponse(
                call: Call<MutableList<MovieModel>>,
                response: Response<MutableList<MovieModel>>
            ) {
                Log.e(TAG,"onResponse" + response.code())
                if (response.isSuccessful) {
                    data.value = response.body()
                }
                else {
                    data.value = null
                }
            }

            override fun onFailure(call: Call<MutableList<MovieModel>>, t: Throwable) {
                Log.e(TAG,"onResponse" + t.message)
                data.value = null
            }

        })
        return data
    }
}