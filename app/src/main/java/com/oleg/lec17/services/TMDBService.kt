package com.oleg.lec17.services

import com.oleg.lec17.models.GenreResponse
import com.oleg.lec17.models.MovieResponse
import com.oleg.lec17.network.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface TMDBService {

    @GET("3/discover/movie?sort_by=popularity.desc")
    suspend fun popularMovies():MovieResponse

    @GET("3/genre/movie/list")
    suspend fun genres(): GenreResponse

    //Setup:
    companion object {
        fun create(): TMDBService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TMDBService::class.java)
        }
    }

}