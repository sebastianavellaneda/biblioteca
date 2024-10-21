package com.example.biblioteca.Data.Entidades

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "autores")
data class Autor(
    @PrimaryKey(autoGenerate = true)
    val autorId: Int = 0,
    val nombre: String,
    val apellido: String,
    val nacionalidad: String
)
