package com.oleg.lec17.repository

import androidx.lifecycle.LiveData
import com.oleg.lec17.database.dao.FilmDao
import com.oleg.lec17.models.FilmsWithGenres
import kotlinx.coroutines.Dispatchers

class MovieRepository(private val filmDao: FilmDao) {
    suspend fun getFilmsWithGenres():LiveData<List<FilmsWithGenres>> {
        return with(Dispatchers.IO){
            //async code for fetching from server
            filmDao.getFilmWithGenres()
        }
    }
}