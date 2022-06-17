package com.example.uas_ppbl.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.data.model.latest.PhoneLast
import com.example.uas_ppbl.databinding.ItemPhoneBinding

class LatestAdapter() : RecyclerView.Adapter<LatestAdapter.LatestViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<PhoneLast>() {
        override fun areItemsTheSame(oldItem: PhoneLast, newItem: PhoneLast): Boolean {
            return oldItem.slug == newItem.slug
        }

        override fun areContentsTheSame(oldItem: PhoneLast, newItem: PhoneLast): Boolean {
            return (oldItem.slug == newItem.slug)
        }

    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestViewHolder {
        val binding = ItemPhoneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return LatestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LatestViewHolder, position: Int) {
        val phone = differ.currentList[position]
        holder.bind(phone)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

//    fun setList(list: List<Phone>){
//        phonesHomeList.addAll(list)
//    }

    inner class LatestViewHolder(private val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(phoneLast: PhoneLast) {
            binding.apply {
                Log.d("Name",phoneLast.phoneName.toString())
                Glide.with(image.context)
                    .load(phoneLast.image)
                    .into(image)

                name.text = phoneLast.phoneName
            }
        }
    }

}