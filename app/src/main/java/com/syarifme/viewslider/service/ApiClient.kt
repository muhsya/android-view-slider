package com.syarifme.viewslider.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by syarifme on 15/11/17.
 */
class ApiClient {
    companion object {
        fun getClient() : Retrofit {
            val BASE_URL = "https://api.themoviedb.org/3/"
            val retrofit: Retrofit = Retrofit.Builder().
                    baseUrl(BASE_URL).
                    addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit
        }

        fun getApiKey() : String {
            val API_KEY = "2dc36de43709cd8544fea9537f938cea"
            return API_KEY;
        }

        fun getBasePosterPath() : String {
            return "https://image.tmdb.org/t/p/w500"
        }
    }
}