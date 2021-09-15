package com.example.resumo_app.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.resumo_app.R
import com.example.resumo_app.adapter.AdapterImages
import com.example.resumo_app.databinding.FeedFragmentBinding
import com.example.resumo_app.model.Image
import com.example.resumo_app.view_model.FeedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment(R.layout.feed_fragment) {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private lateinit var viewModel: FeedViewModel
    private lateinit var binding : FeedFragmentBinding
    private val adapterImages = AdapterImages()

    private val observeImages = Observer<List<Image>>{
        adapterImages.update(it)
    }

    private val observerPages = Observer<Int> {
        viewModel.fetchImages(page = it)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FeedFragmentBinding.bind(view)
        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)

//        //findNavController sempre padrão para navegar para outro fragment
//        binding.buttonNavigateToDetails.setOnClickListener{
//            findNavController().navigate(R.id.action_feedFragment_to_detailsFragment)
//        }

        viewModel.image.observe(viewLifecycleOwner, observeImages)
        viewModel.page.observe(viewLifecycleOwner, observerPages)

        setupRecyclerView()

        binding.buttonNextPage.setOnClickListener{
            viewModel.nextPage()
        }
    }

    fun setupRecyclerView() = with(binding.feedRecyclerView){
        adapter = adapterImages
        layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.nextPage()
    }

}