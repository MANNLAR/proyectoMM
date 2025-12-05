package com.example.projectmovil

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    // Instancia única (singleton) de la BD
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "project_movil_db"     // nombre del archivo de BD
            )
                // .fallbackToDestructiveMigration() // (opcional) borrar/crear BD si cambias versión
                .build()
            INSTANCE = instance
            instance
        }
    }
}
