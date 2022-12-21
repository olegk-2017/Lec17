package com.oleg.lec17.models

import androidx.room.*
import com.oleg.lec17.database.dao.FilmDao
import java.util.*

@Entity
data class Film(
    val title: String,
    @PrimaryKey
    val id: String = UUID.randomUUID().toString()
)

//many to many
@Entity(primaryKeys = ["filmId","genreId"])
data class FilmGenreCrossRef(
    val filmId:String,
    val genreId:String

    //    @PrimaryKey
    //    val fgID: String = UUID.randomUUID().toString()

)

data class FilmsWithGenres(
    @Embedded
    val film: Film,

    @Relation(
        parentColumn = "filmId",
        entityColumn = "genreId",
        associateBy = Junction(FilmGenreCrossRef::class)
    )
    val genres: List<FGenre>
)
