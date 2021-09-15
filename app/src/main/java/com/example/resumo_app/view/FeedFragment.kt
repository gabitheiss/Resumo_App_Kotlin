package com.example.resumo_app.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.resumo_app.R
import com.example.resumo_app.adapter.AdapterImages
import com.example.resumo_app.adapter.HeaderAdapterFilter
import com.example.resumo_app.databinding.FeedFragmentBinding
import com.example.resumo_app.model.ImageModel
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
    private lateinit var adaptersConcat : ConcatAdapter
    var clearList = false

    private  var headerAdapterFilter = HeaderAdapterFilter {
        clearList = true
        viewModel.searchFor(it)
    }

    private val observeImages = Observer<List<ImageModel>>{
        adapterImages.update(it,clearList)
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
        adaptersConcat = ConcatAdapter(headerAdapterFilter, adapterImages)

        setupRecyclerView()

        binding.buttonNextPage.setOnClickListener{
            clearList = false
            viewModel.nextPage()
        }
    }

    fun setupRecyclerView() = with(binding.feedRecyclerView){
        adapter = adaptersConcat
        layoutManager = LinearLayoutManager(requireContext())
        //layoutManager = GridLayoutManager(requireContext(),2)
        viewModel.nextPage()
    }

}