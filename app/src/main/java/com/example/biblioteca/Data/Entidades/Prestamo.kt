package com.example.biblioteca.Data.Entidades

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "prestamos",
    foreignKeys = [
        ForeignKey(entity = Libro::class, parentColumns = ["libroId"], childColumns = ["libroId"]),
        ForeignKey(entity = Miembro::class, parentColumns = ["miembroId"], childColumns = ["miembroId"])
    ]
)
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val prestamoId: Int = 0,
    val libroId: Int,
    val miembroId: Int,
    val fechaPrestamo: String,
    val fechaDevolucion: String?
)
