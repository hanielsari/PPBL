package com.example.uas_ppbl.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_ppbl.data.model.brand.Brand
import com.example.uas_ppbl.databinding.ItemBrandsBinding

class BrandsAdapter : RecyclerView.Adapter<BrandsAdapter.BrandViewHolder>() {
    private val callback = object : DiffUtil.ItemCallback<Brand>() {
        override fun areItemsTheSame(oldItem: Brand, newItem: Brand): Boolean {
            return oldItem.brandSlug == newItem.brandSlug
        }

        override fun areContentsTheSame(oldItem: Brand, newItem: Brand): Boolean {
            return (oldItem == newItem)
        }

    }
    val differ = AsyncListDiffer(this, callback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val binding = ItemBrandsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BrandViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val brand = differ.currentList[position]
        holder.bind(brand)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    inner class BrandViewHolder(private val binding: ItemBrandsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(brand: Brand) {
            binding.apply {
                tvTitle.text = brand.brandName
                root.setOnClickListener {
                    onItemClickListener?.let {
                        it(brand)
                    }
                }
            }

        }
    }

    private var onItemClickListener: ((Brand) -> Unit)? = null
    fun setOnItemListener(listener: (Brand) -> Unit) {
        onItemClickListener = listener
    }
}