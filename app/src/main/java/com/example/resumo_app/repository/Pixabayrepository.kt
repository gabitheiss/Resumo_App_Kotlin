package com.example.resumo_app.repository

import com.example.resumo_app.model.Image
import com.example.resumo_app.services.PixabayApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject


class Pixabayrepository @Inject constructor(private val service: PixabayApi) {


    suspend fun fetchImages(q: String, page : Int): List<Image>? {
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
}


