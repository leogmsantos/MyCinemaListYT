package br.com.entrypoint.mycinemalistyt.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PopularMovieDto(
    val id: Long,
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("vote_average")
    val voteAverage: Double
)
