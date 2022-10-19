package com.example.mvvmjson.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmjson.Model.MovieModel
import com.example.mvvmjson.Repositories.MainRepo

class MainActivityViewModel: ViewModel() {
    private val mainRepo: MainRepo
    val getMovieList: LiveData<MutableList<MovieModel>>
    get() = mainRepo.getMovieLiveData

    init {
        mainRepo = MainRepo()
    }

}