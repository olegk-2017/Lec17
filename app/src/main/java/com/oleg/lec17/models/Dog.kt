package com.oleg.lec17.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Dog(
    @ColumnInfo(name = "dog_name")
    val name:String,
    @PrimaryKey
    val dogId:String = UUID.randomUUID().toString(),

    val ownerId:String
)
