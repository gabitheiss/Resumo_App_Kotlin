package com.example.resumo_app.repository

import com.example.resumo_app.database.PixabayDAO
import com.example.resumo_app.model.ImageModel
import com.example.resumo_app.services.PixabayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class Pixabayrepository @Inject constructor(private val service: PixabayApi,
                                            private val pixabayDAO: PixabayDAO) {


    suspend fun fetchImages(q: String, page : Int): List<ImageModel>? {
        return withContext(Dispatchers.Default) {
            val response = service.getImages(q = q, page = page)
            val processedResponse = processData(response)
            processedResponse?.hits
        }
    }

    private fun <T> processData(response: Response<T>): T? {
        return if (response.isSuccessful) response.body()
        else null
    }

    suspend fun insert(listOf: List<ImageModel>): Boolean {
        return withContext(Dispatchers.Default) {
            pixabayDAO.insert(listOf)
            true
        }
    }

    suspend fun fetchFromDb(): List<ImageModel> {
        return withContext(Dispatchers.Default) {
            pixabayDAO.fetch()
        }
    }

}


