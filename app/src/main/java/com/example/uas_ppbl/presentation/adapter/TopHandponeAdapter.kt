package com.example.uas_ppbl.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ppbl.data.model.tophandphone.Phone
import com.example.uas_ppbl.databinding.ItemBrandsBinding
import com.example.uas_ppbl.databinding.ItemPhoneBinding

class TopHandponeAdapter() : RecyclerView.Adapter<TopHandponeAdapter.TopHandphoneViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Phone>() {
        override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.slug == newItem.slug
        }

        override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return (oldItem.slug == newItem.slug)
        }

    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopHandphoneViewHolder {
        val binding = ItemBrandsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TopHandphoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopHandphoneViewHolder, position: Int) {
        val phone = differ.currentList[position]
        holder.bind(phone)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

//    fun setList(list: List<Phone>){
//        phonesHomeList.addAll(list)
//    }

    inner class TopHandphoneViewHolder(private val binding: ItemBrandsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(phone: Phone) {
            binding.apply {
                tvTitle.text = phone.phoneName
            }
        }
    }

}