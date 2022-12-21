package com.oleg.lec17.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID

@Entity
data class Review(
    val text:String,
    //each review must belong to movie
    val reviewedFilmId:String,

    @PrimaryKey
    val reviwId:String = UUID.randomUUID().toString()
)

data class FilmWithReview(
    @Embedded
    val film:Film,

    @Relation(
        parentColumn = "filmId",
        entityColumn = "reviewedFilmId"
    )
    val reviews:List<Review>?
)
