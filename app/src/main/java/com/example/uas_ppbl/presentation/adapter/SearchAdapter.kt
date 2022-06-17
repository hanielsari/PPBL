package com.example.uas_ppbl.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ppbl.data.model.Search.Data
import com.example.uas_ppbl.databinding.ItemPhoneBinding

class SearchAdapter(): RecyclerView.Adapter<SearchAdapter.SearchedViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.brand == newItem.brand
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return (oldItem.brand == newItem.brand)
        }

    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchedViewHolder {
        val binding = ItemPhoneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SearchedViewHolder(binding)
    }
    override fun onBindViewHolder(holder: SearchedViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class SearchedViewHolder(private val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data) {
            binding.apply {
                Glide.with(image.context)
                    .load(data.phoneImages)
                    .into(image)

                name.text = data.phoneName
                Log.d("Name",data.phoneName.toString())
            }
        }
    }
}