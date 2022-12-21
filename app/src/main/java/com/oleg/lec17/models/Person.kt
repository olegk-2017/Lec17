package com.oleg.lec17.models

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Entity(tableName = "people")
data class Person(
    val name: String,
    @PrimaryKey val personId: String = UUID.randomUUID().toString(),
)


data class PersonWithDog(
    @Embedded
    val person: Person,

    @Relation(
        parentColumn = "personId",
        entityColumn = "dogId"
    )
    val dog: Dog?
)
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

