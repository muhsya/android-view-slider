package com.syarifme.viewslider.model

import com.google.gson.annotations.SerializedName

/**
 * Created by syarifme on 15/11/17.
 */
data class Movie(@SerializedName("original_title") val originalTitle : String?,
                 @SerializedName("overview") val overview : String?,
                 @SerializedName("poster_path") val posterPath : String?)