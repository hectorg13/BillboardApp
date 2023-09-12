package com.smartsolution.billboardapp.model.network

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var originalTitle: String,
    @SerializedName("overview")
    var overview: String,
    @SerializedName("poster_path")
    var posterPath: String,
    @SerializedName("release_date")
    var release_date: String,
    @SerializedName("vote_avegare")
    var voteAverage: String,
    @SerializedName("vote_count")
    var voteCount:String
)
