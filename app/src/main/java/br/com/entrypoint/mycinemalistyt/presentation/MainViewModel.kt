package br.com.entrypoint.mycinemalistyt.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.entrypoint.mycinemalistyt.data.remote.MoviesAPI
import br.com.entrypoint.mycinemalistyt.data.remote.response.PopularMovieResponse
import br.com.entrypoint.mycinemalistyt.domain.PopularMovie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel (
    val api: MoviesAPI
    ) : ViewModel() {

    private val _popularMovies = MutableLiveData<List<PopularMovie>>()
    val popularMovies: LiveData<List<PopularMovie>> get() = _popularMovies

    private val _popularMoviesErrorResponse = MutableLiveData<String>()
    val popularMoviesErrorResponse: LiveData<String?> get() = _popularMoviesErrorResponse

    suspend fun getPopularMovies() = withContext(Dispatchers.Main){
        val call: Call<PopularMovieResponse> = api.getPopularMovies()
        call.enqueue(
            object : Callback<PopularMovieResponse>{
                override fun onResponse(
                    call: Call<PopularMovieResponse>,
                    response: Response<PopularMovieResponse>
                ) {
                    if (response.isSuccessful){
                        _popularMovies.value = response.body()?.popularMovie?.map { it.toPopularMovie() }
                    }
                }

                override fun onFailure(call: Call<PopularMovieResponse>, error: Throwable) {
                    _popularMoviesErrorResponse.value = error.message
                }

            }
        )

    }

}