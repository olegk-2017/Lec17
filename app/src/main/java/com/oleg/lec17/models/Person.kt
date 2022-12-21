package com.oleg.lec17.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "people")
class Person {
    val name:String = ""
    @PrimaryKey
    val id:Int = 0
}