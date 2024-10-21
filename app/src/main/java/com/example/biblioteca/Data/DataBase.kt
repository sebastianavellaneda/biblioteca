package com.example.biblioteca.Data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.biblioteca.Data.Dao.AutorLibroDao
import com.example.biblioteca.Data.Dao.PrestamoMiembroDao
import com.example.biblioteca.Data.Entidades.Autor
import com.example.biblioteca.Data.Entidades.Libro
import com.example.biblioteca.Data.Entidades.Miembro
import com.example.biblioteca.Data.Entidades.Prestamo

@Database(
    entities = [Autor::class, Libro::class, Miembro::class, Prestamo::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun autorLibroDao(): AutorLibroDao
    abstract fun prestamoMiembroDao(): PrestamoMiembroDao
}
