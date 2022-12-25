package com.oleg.lec17

import android.app.Application
import android.net.ConnectivityManager
import com.oleg.lec17.database.AppDatabase
import com.oleg.lec17.network.NetworkStatusChecker
import com.oleg.lec17.repository.MovieRepository
import kotlinx.coroutines.selects.SelectInstance

class MoviesApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        println("App Start")

        instance = this
    }

    companion object{
        private lateinit var instance: MoviesApplication

        private val db:AppDatabase by lazy {
            AppDatabase.create(instance)
        }

        val repository:MovieRepository by lazy {
            MovieRepository(db.filmDao())
        }

        val networkStatusChecker:NetworkStatusChecker by lazy {
            val connectivityManager = instance.getSystemService(ConnectivityManager::class.java)
            NetworkStatusChecker(connectivityManager)
        }
    }
}