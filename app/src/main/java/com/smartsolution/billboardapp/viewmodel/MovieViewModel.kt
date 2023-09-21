package com.smartsolution.billboardapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartsolution.billboardapp.model.network.MovieModel

class MovieViewModel : ViewModel() {
    private var _currentMovie = MutableLiveData<MovieModel>()
    val currentMovie: LiveData<MovieModel> = _currentMovie

    fun setMovie(movie: MovieModel) {
        _currentMovie.value = movie
    }

    /*init {
        _currentMovie.value = MovieModel("Default", "Default", "Default", "Default", "Default", "Default", "Default")
    }*/
}