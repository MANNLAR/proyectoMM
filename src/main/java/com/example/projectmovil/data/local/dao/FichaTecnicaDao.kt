package com.example.projectmovil

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.flow.Flow

@Dao
interface FichaTecnicaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(ficha: FichaTecnicaEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(fichas: List<FichaTecnicaEntity>)

    @Update
    suspend fun update(ficha: FichaTecnicaEntity)

    @Delete
    suspend fun delete(ficha: FichaTecnicaEntity)

    @Query("DELETE FROM fichas_tecnicas")
    suspend fun deleteAll()

    // Todas las fichas, ordenadas por id descendente (más nuevas primero)
    @Query("SELECT * FROM fichas_tecnicas ORDER BY id DESC")
    fun observeAll(): Flow<List<FichaTecnicaEntity>>

    @Query("SELECT * FROM fichas_tecnicas WHERE id = :idFicha LIMIT 1")
    suspend fun getById(idFicha: Int): FichaTecnicaEntity?
}
