package com.example.biblioteca.Data.Relacion

import androidx.room.Embedded
import androidx.room.Relation
import com.example.biblioteca.Data.Entidades.Libro
import com.example.biblioteca.Data.Entidades.Prestamo

data class LibroConPrestamos(
    @Embedded val libro: Libro,
    @Relation(
        parentColumn = "libroId",
        entityColumn = "libroId"
    )
    val prestamos: List<Prestamo>
)
