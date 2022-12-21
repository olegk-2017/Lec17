package com.oleg.lec17.database.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.oleg.lec17.models.Dog
import com.oleg.lec17.models.Person
import com.oleg.lec17.models.PersonWithDog

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // INSERT INTO People(id, name) VALUES('', '')
    suspend fun add(person: Person)

    @Query("SELECT * FROM people")
    fun getAll(): LiveData<List<Person>>

    //dogs:
    @Insert(onConflict = OnConflictStrategy.REPLACE) // INSERT INTO People(id, name) VALUES('', '')
    suspend fun add(dog: Dog)

    @Query("SELECT * FROM Dog")
    fun getDogs(): LiveData<List<Dog>>


    //people with dogs:
    @Query("SELECT * FROM people")
    fun getPeopleWithDogs(): LiveData<List<PersonWithDog>>
}

