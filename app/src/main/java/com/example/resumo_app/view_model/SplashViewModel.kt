package com.example.resumo_app.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resumo_app.repository.Pixabayrepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val pixabayrepository: Pixabayrepository) : ViewModel() {


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    fun loadData() {
        viewModelScope.launch {
            _isLoading.value = true
            val listOfImages = pixabayrepository.fetchImages("", 1)
            listOfImages?.let {
                pixabayrepository.insert(it)
            }
            //depois de terminar tudo, ainda esperamos mais 2s
            delay(4000)
            _isLoading.value = false
        }
    }


    //isLoading enquanto esta carregando sera true, depois de tudo carregado será false pois ja terminou
}