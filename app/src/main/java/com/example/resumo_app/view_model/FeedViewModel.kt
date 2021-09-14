package com.example.resumo_app.view_model


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumo_app.model.Image
import com.example.resumo_app.repository.Pixabayrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val repository : Pixabayrepository) : ViewModel() {

    private val _image = MutableLiveData<List<Image>>()
    val image : LiveData<List<Image>> = _image


    fun fetchImages(q: String = ""){
        viewModelScope.launch {
            val returnImages = repository.fetchImages(q = q)
            returnImages?.let {
                _image.value = it
            }
        }
    }
}