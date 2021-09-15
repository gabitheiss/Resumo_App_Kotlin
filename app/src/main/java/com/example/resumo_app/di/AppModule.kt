package com.example.resumo_app.di

import android.content.Context
import com.example.resumo_app.database.AppDatabase
import com.example.resumo_app.database.PixabayDAO
import com.example.resumo_app.services.PixabayApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://pixabay.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPixabayApi(retrofit: Retrofit) : PixabayApi =
        retrofit.create(PixabayApi::class.java)


    @Provides
    fun providePixabayDao(@ApplicationContext context: Context): PixabayDAO {
        return AppDatabase.getDatabase(context).getPixabayDao()
    }



}