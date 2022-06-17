package com.example.uas_ppbl.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.uas_ppbl.data.model.device.Phone
import com.example.uas_ppbl.databinding.ItemPhoneBinding

class DeviceAdapter(
) : RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>() {


    private val callback = object : DiffUtil.ItemCallback<Phone>() {
        override fun areItemsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return oldItem.brand == newItem.brand
        }

        override fun areContentsTheSame(oldItem: Phone, newItem: Phone): Boolean {
            return (oldItem.brand == newItem.brand)
        }

    }
    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val binding = ItemPhoneBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DeviceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        val phone = differ.currentList[position]
        holder.bind(phone)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

//    fun setList(list: List<Phone>){
//        phonesHomeList.addAll(list)
//    }

    inner class DeviceViewHolder(private val binding: ItemPhoneBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(phone: Phone) {
            binding.apply {
                Log.d("Name",phone.phoneName.toString())
                Glide.with(image.context)
                    .load(phone.image)
                    .into(image)

                name.text = phone.phoneName
            }
        }
    }

}