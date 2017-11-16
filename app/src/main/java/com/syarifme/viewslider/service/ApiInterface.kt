package com.syarifme.viewslider.service

import com.syarifme.viewslider.model.Movie
import com.syarifme.viewslider.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by syarifme on 15/11/17.
 */

interface ApiInterface {
    @GET("movie/latest")
    fun getMovieLatest(@Query("api_key") apiKey : String) : Call<Movie>
    @GET("movie/popular")
    fun getPopularMovie(@Query("api_key") apiKey: String) : Call<MovieResponse>
}