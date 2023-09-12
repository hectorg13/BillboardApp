package com.smartsolution.billboardapp.model.network

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("results")
    var results: List<MovieModel>
)
