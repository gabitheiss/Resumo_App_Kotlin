package com.example.resumo_app.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resumo_app.R
import com.example.resumo_app.databinding.DetailsFragmentBinding
import com.example.resumo_app.view_model.DetailsViewModel

class DetailsFragment : Fragment(R.layout.details_fragment) {

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding : DetailsFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        binding = DetailsFragmentBinding.bind(view)

        //popBackStack para fechar a tela - fechar o fragment
        binding.buttonClose.setOnClickListener{
            findNavController().navigate(R.id.action_detailsFragment_to_userFragment)

        }
    }

}