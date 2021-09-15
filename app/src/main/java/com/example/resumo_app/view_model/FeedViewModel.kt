package com.example.resumo_app.view_model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumo_app.model.ImageModel
import com.example.resumo_app.repository.Pixabayrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val repository: Pixabayrepository) : ViewModel() {

    private val _image = MutableLiveData<List<ImageModel>>()
    val image: LiveData<List<ImageModel>> = _image

    private val _page = MutableLiveData<Int>()
    val page: LiveData<Int> = _page

    private var query : String? = null

    fun fetchImages(page: Int = 1) {
        viewModelScope.launch {
            val returnImages = repository.fetchImages(q = query ?: "", page = page)

            returnImages?.let {
                _image.value = it
            }
        }
    }

    fun nextPage() {
        //se for null é 0
        _page.value = (_page.value ?: 0) + 1
    }

    fun searchFor(q : String){
        query= q
        _page.value = 1
    }
}