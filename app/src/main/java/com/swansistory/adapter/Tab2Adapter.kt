package com.swansistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.swansistory.R
import com.swansistory.fragment.Tab2FragmentDirections
import com.swansistory.room.Place

class Tab2Adapter : ListAdapter<Place, Tab1Adapter.ViewHolder>(this) {

    companion object : DiffUtil.ItemCallback<Place>() {
        override fun areItemsTheSame(oldItem: Place, newItem: Place) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Place, newItem: Place) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tab1Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_place, parent, false)
        return Tab1Adapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Tab1Adapter.ViewHolder, position: Int) {
        val item = getItem(position)
        val itemView = holder.itemView
        itemView.findViewById<TextView>(R.id.item_name).text = item.name
        itemView.findViewById<TextView>(R.id.item_location).text = item.address
        val imgResID = itemView.resources.getIdentifier(item.imgUrl,"drawable",itemView.context.packageName)
        Glide.with(holder.itemView.context).load(imgResID).into(itemView.findViewById(R.id.item_image))
        itemView.findViewById<Button>(R.id.explore_btn).setOnClickListener {
            val action = Tab2FragmentDirections.actionTab2FragmentToMapViewFragment(item)
            itemView.findNavController()
                .navigate(action)
        }
    }
}