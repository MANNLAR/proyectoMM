package com.example.projectmovil

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FichaTecnicaEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun fichaTecnicaDao(): FichaTecnicaDao
}
