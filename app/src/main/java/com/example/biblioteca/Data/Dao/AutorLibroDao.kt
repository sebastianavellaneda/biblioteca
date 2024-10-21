package com.example.biblioteca.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.biblioteca.Data.Entidades.Autor
import com.example.biblioteca.Data.Entidades.Libro
import com.example.biblioteca.Data.Relacion.AutorConLibros

@Dao
interface AutorLibroDao {

    @Insert
    suspend fun insertarAutor(autor: Autor)

    @Insert
    suspend fun insertarLibro(libro: Libro)

    @Transaction
    @Query("SELECT * FROM autores WHERE autorId = :autorId")
    suspend fun obtenerAutorConLibros(autorId: Int): AutorConLibros

}
