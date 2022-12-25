package com.oleg.lec17.models

import com.google.gson.annotations.SerializedName

data class GenreResponse(
    @SerializedName("results")
    val genres: List<Genre>,
    //statusCode
    @SerializedName("status_code")
    val statusCode:String?,

    //statusMessage
    @SerializedName("status_message")
    val statusMessage:String?,
    //success
val success:Boolean?
)
