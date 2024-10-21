package com.example.biblioteca.Data.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.biblioteca.Data.Entidades.Miembro
import com.example.biblioteca.Data.Entidades.Prestamo

@Dao
interface PrestamoMiembroDao {

    @Insert
    suspend fun insertarMiembro(miembro: Miembro)

    @Insert
    suspend fun insertarPrestamo(prestamo: Prestamo)

    @Query("SELECT * FROM prestamos WHERE libroId = :libroId")
    suspend fun obtenerPrestamosPorLibro(libroId: Int): List<Prestamo>
}
