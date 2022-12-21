package com.oleg.lec17.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.oleg.lec17.database.dao.FilmDao
import com.oleg.lec17.database.dao.PeopleDao
import com.oleg.lec17.models.*


const val DB_NAME = "AppDatabase"
const val DB_VERSION = 1

@Database(entities = [Person::class,Dog::class,Review::class,Film::class,FGenre::class,FilmGenreCrossRef::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    //expose the dao's:
    abstract fun peopleDao(): PeopleDao
    abstract fun filmDao():FilmDao

    companion object{
        fun create(context:Context):AppDatabase =
             Room
                 .databaseBuilder(context,AppDatabase::class.java, DB_NAME)
                 .fallbackToDestructiveMigration() //if a new version of the app is installed AND db structure was upgraded => delete the db and re-create it
                 .build()

    }
}
