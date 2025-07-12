package com.bbc.bbc_mobile.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bbc.bbc_mobile.data.remote.response.IceCreamResponse
import com.bbc.bbc_mobile.databinding.ItemProduct2Binding
import com.bbc.bbc_mobile.databinding.ItemProductCardBinding
import com.bumptech.glide.Glide

class Adapter(
    private val type: Type,
    private val onItemClick: (IceCreamResponse) -> Unit
    ) :
    ListAdapter<IceCreamResponse, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    enum class Type {
        HORIZONTAL, VERTICAL
    }

    companion object {
        private const val TYPE_HORIZONTAL = 1
        private const val TYPE_VERTICAL = 2

        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<IceCreamResponse>() {
            override fun areItemsTheSame(oldItem: IceCreamResponse, newItem: IceCreamResponse) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: IceCreamResponse, newItem: IceCreamResponse) =
                oldItem == newItem
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (type) {
            Type.HORIZONTAL -> TYPE_HORIZONTAL
            Type.VERTICAL -> TYPE_VERTICAL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HORIZONTAL -> {
                val binding = ItemProductCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                val holder = HorizontalViewHolder(binding)

                holder.itemView.setOnClickListener {
                    val position = holder.adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val item = getItem(position)
                        onItemClick(item)
                    }
                }
                holder
            }

            TYPE_VERTICAL -> {
                val binding = ItemProduct2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                val holder = VerticalViewHolder(binding)

                holder.itemView.setOnClickListener {
                    val position = holder.adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val item = getItem(position)
                        onItemClick(item)
                    }
                }
                holder
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is HorizontalViewHolder -> holder.bind(item)
            is VerticalViewHolder -> holder.bind(item)
        }
    }

    class HorizontalViewHolder(private val binding: ItemProductCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(iceCream: IceCreamResponse) {
            binding.tvProductName.text = iceCream.name
            binding.tvProductPrice.text = iceCream.price.toString()
            Glide.with(binding.root.context)
                .load(iceCream.images)
                .into(binding.ivProductImage)
        }
    }

    class VerticalViewHolder(private val binding: ItemProduct2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(iceCream: IceCreamResponse) {
            binding.tvProductName.text = iceCream.name
            binding.tvProductPrice.text = iceCream.price.toString()
            Glide.with(binding.root.context)
                .load(iceCream.images)
                .into(binding.ivProductImage)
        }
    }
}
