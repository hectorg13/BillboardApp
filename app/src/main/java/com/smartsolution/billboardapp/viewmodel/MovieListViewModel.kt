package com.smartsolution.billboardapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smartsolution.billboardapp.model.Constants
import com.smartsolution.billboardapp.model.core.RetrofitClient
import com.smartsolution.billboardapp.model.network.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListViewModel : ViewModel() {

    private var _listMovies = MutableLiveData<List<MovieModel>>()
    val listMovies: LiveData<List<MovieModel>> = _listMovies

    fun getBillboard() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getBillboard(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _listMovies.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getPopulars() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getPopulars(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _listMovies.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getTopRated() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.getTopRated(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _listMovies.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }
}