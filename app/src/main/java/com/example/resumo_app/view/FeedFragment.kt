package com.example.resumo_app.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.resumo_app.R
import com.example.resumo_app.databinding.FeedFragmentBinding
import com.example.resumo_app.view_model.FeedViewModel

class FeedFragment : Fragment(R.layout.feed_fragment) {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding : FeedFragmentBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

        //findNavController sempre padrão para navegar para outro fragment
        binding.buttonNavigateToDetails.setOnClickListener{
            findNavController().navigate(R.id.action_feedFragment_to_detailsFragment)
        }
    }

}