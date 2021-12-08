package br.com.entrypoint.mycinemalistyt.domain

data class PopularMovie(
    val id: Long,
    val title: String,
    val description: String,
    val voteAverage: Double
)
