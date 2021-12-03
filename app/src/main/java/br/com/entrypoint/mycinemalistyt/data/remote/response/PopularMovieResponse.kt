package br.com.entrypoint.mycinemalistyt.data.remote.response

import br.com.entrypoint.mycinemalistyt.data.remote.dto.PopularMovieDto
import com.google.gson.annotations.SerializedName

data class PopularMovieResponse(
    @SerializedName("results")
    val popularMovie: List<PopularMovieDto>
)
