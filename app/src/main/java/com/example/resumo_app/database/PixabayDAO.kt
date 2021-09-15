package com.example.resumo_app.database


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.example.resumo_app.model.ImageModel


@Dao
interface PixabayDAO {


    @Insert(onConflict = REPLACE)
    suspend fun insert(list: List<ImageModel>)

    @Query("select * from imagemodel")
    suspend fun fetch() : List<ImageModel>

}