package com.example.resumo_app.view

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.resumo_app.R
import com.example.resumo_app.databinding.SplashFragmentBinding
import com.example.resumo_app.view_model.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*


@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.splash_fragment) {


    private lateinit var viewModel: SplashViewModel
    private lateinit var binding: SplashFragmentBinding


    //ficar observando o liveData do viewModel, dai sabe quando esta tudo carregado para abrir o feed fragment
    private val observerLoadingData = Observer<Boolean> {
        if (!it) {
            findNavController().navigate(R.id.action_splashFragment_to_feedFragment)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        binding = SplashFragmentBinding.bind(view)

        viewModel.isLoading.observe(viewLifecycleOwner, observerLoadingData)
        viewModel.loadData()

    }

}