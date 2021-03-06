package com.example.resumo_app.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resumo_app.R
import com.example.resumo_app.databinding.HeaderSearchBinding

class HeaderAdapterFilter(private val onSearch : (String) -> Unit) : RecyclerView.Adapter<HeaderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        LayoutInflater.from(parent.context).inflate(R.layout.header_search,parent,false).apply {
            return HeaderViewHolder(this,onSearch)
        }
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = 1
}


class HeaderViewHolder(itemView : View, private val onSearch: (String) -> Unit) : RecyclerView.ViewHolder(itemView){

    private val binding : HeaderSearchBinding = HeaderSearchBinding.bind(itemView)

    fun bind(){
        binding.ediTextSearch.addTextChangedListener(object : TextWatcher{

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                p0?.let{
                    if(it.length > 3){
                        onSearch(it.toString())
                    }
                    //apagando a pesquisa retorna a lista inicial
                    if(it.isNotEmpty()){
                        onSearch(it.toString())
                    }
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })



    }

}