package com.example.biblioteca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import com.example.biblioteca.Data.AppDatabase
import com.example.biblioteca.Data.Dao.AutorLibroDao
import com.example.biblioteca.Data.Relacion.AutorConLibros
import com.example.biblioteca.ui.theme.BibliotecaTheme

// Clase principal de la actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear la base de datos usando Room
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "biblioteca-database" // Nombre de la base de datos
        ).build()

        // Establecer el contenido de la actividad usando Compose
        setContent {
            BibliotecaTheme { // Aplicar el tema de la aplicación
                // Llamar a la vista principal pasando el DAO
                AuthorBookView(db.autorLibroDao())
            }
        }
    }
}

// Función composable para mostrar autores y sus libros
@Composable
fun AuthorBookView(dao: AutorLibroDao) {
    // Crear un alcance para las corrutinas
    val coroutineScope = rememberCoroutineScope()
    // Estado que contiene la lista de autores
    var autores by remember { mutableStateOf<List<AutorConLibros>>(emptyList()) }

    // Ejecutar este efecto cuando el componente se inicia
    LaunchedEffect(Unit) {
        // Obtener autores con sus libros desde la base de datos
        autores = listOf(dao.obtenerAutorConLibros(1)) // Cambia el ID según sea necesario
    }

    // Contenedor vertical para mostrar la lista
    Column {
        // Iterar sobre la lista de autores
        autores.forEach { autorConLibros ->
            // Mostrar el nombre y apellido del autor
            Text(text = "Autor: ${autorConLibros.autor.nombre} ${autorConLibros.autor.apellido}")
            // Iterar sobre los libros del autor y mostrarlos
            autorConLibros.libros.forEach { libro ->
                Text(text = "- Libro: ${libro.titulo}") // Mostrar el título del libro
            }
        }
    }
}

// Función para la previsualización en Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BibliotecaTheme { // Aplicar el tema de la aplicación
        // Aquí puedes añadir componentes para la previsualización
    }
}
