package com.example.biblioteca.Data.Relacion

import androidx.room.Embedded
import androidx.room.Relation
import com.example.biblioteca.Data.Entidades.Autor
import com.example.biblioteca.Data.Entidades.Libro

data class AutorConLibros(
    @Embedded val autor: Autor,
    @Relation(
        parentColumn = "autorId",
        entityColumn = "autorId"
    )
    val libros: List<Libro>
)
