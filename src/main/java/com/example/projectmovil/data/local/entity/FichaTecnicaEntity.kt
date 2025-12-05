package com.example.projectmovil

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fichas_tecnicas")
data class FichaTecnicaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val titulo: String,            // nombre de la receta
    val descripcion: String,       // descripción breve
    val categoria: String,         // postre, desayuno, saludable, etc.
    val tiempoMinutos: Int,        // tiempo estimado
    val costoAprox: Double,        // costo aproximado
    val fechaCreacion: Long,       // en millis (System.currentTimeMillis())
    val ratingPromedio: Float = 0f // para puntuaciones
    // aquí luego puedes agregar: lista de ingredientes serializada, etc.
)
