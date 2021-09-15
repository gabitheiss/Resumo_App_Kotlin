package com.example.resumo_app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.resumo_app.model.ImageModel


@Database(entities = [ImageModel::class], version = 1)

abstract class AppDatabase : RoomDatabase(){


    // funcao declarada para o Room implementar automaticamente nosso DAO
    abstract fun getPixabayDao(): PixabayDAO

    companion object {

        //Singleton que irá gerar nossa classe AppDatabse com tudo implementado pelo Room.

        fun getDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "resumo_final_db"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }

}