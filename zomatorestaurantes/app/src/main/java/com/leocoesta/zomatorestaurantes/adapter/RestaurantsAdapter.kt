package com.leocoesta.zomatorestaurantes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leocoesta.zomatorestaurantes.databinding.RestauranteListItemBinding
import com.leocoesta.zomatorestaurantes.model.Restaurant

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, restaurants: List<Restaurant>?) {
    val adapter = recyclerView.adapter as RestaurantsAdapter
    adapter.submitList(restaurants)
}

class RestaurantsAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Restaurant, RestaurantsAdapter.RestaurantViewHolder>(DiffCallback) {

    class RestaurantViewHolder(private var binding: RestauranteListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(restaurant: Restaurant) {
            binding.restaurante = restaurant
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return RestaurantViewHolder(RestauranteListItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = getItem(position)

        holder.bind(restaurant)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(restaurant)
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Restaurant>() {
        override fun areItemsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Restaurant, newItem: Restaurant): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (restaurant: Restaurant) -> Unit) {
        fun onClick(restaurant: Restaurant) = clickListener(restaurant)
    }

}


