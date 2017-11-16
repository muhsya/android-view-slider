package com.syarifme.viewslider.model

import com.google.gson.annotations.SerializedName

/**
 * Created by syarifme on 15/11/17.
 */
data class MovieResponse(var page : Int,
                         val results : ArrayList<Movie>?,
                         val totalResult : Int,
                         val totalPage : Int)