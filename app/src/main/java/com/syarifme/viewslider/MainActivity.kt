package com.syarifme.viewslider

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.syarifme.viewslider.connection.InternetConnection
import com.syarifme.viewslider.model.Movie
import com.syarifme.viewslider.model.MovieResponse
import com.syarifme.viewslider.service.ApiClient
import com.syarifme.viewslider.service.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val TAG : String = MainActivity::class.java.canonicalName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val status : Boolean = InternetConnection.
                getInstance(applicationContext).
                isConnectionAvailable()

        if (status) {
            val apiInterface : ApiInterface = ApiClient.getClient().create(ApiInterface::class.java)
            getLatestMovie(apiInterface)
        }
    }

    fun getPopularMovies(apiInterface: ApiInterface) : ArrayList<Movie>? {
        var movies : ArrayList<Movie>? = null
        val call : Call<MovieResponse> = apiInterface.getPopularMovie(ApiClient.getApiKey())
        call.enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Movie")
            }

            override fun onResponse(call: Call<MovieResponse>?, response: Response<MovieResponse>?) {
                if (response != null) {
                    movies = response.body()?.results
                    Log.d("$TAG", "Berhasil Fetch Popular Movie")
                }
            }

        })

        return movies
    }

    fun getLatestMovie(apiInterface: ApiInterface) : Movie? {
        var movie : Movie? = null
        val call : Call<Movie> = apiInterface.getMovieLatest(ApiClient.getApiKey())
        call.enqueue(object : Callback<Movie> {
            override fun onFailure(call: Call<Movie>?, t: Throwable?) {
                Log.d("$TAG", "Gagal Fetch Popular Movie")
            }

            override fun onResponse(call: Call<Movie>?, response: Response<Movie>?) {
                if (response != null) {
                    var originalTitle : String? = response.body()?.originalTitle
                    var overview : String? = response.body()?.overview
                    var posterPath : String? = response.body()?.posterPath

                    movie = Movie(originalTitle, overview, posterPath)
                    Log.d("$TAG", "Berhasil Fetch Popular Movie ${movie!!.originalTitle}")
                }
            }

        })

        return movie
    }
}
