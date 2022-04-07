package com.swansistory.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.swansistory.R
import com.swansistory.fragment.Tab1FragmentDirections
import com.swansistory.fragment.Tab4FragmentDirections
import com.swansistory.room.Blog
import com.swansistory.room.Place


class Tab4Adapter : ListAdapter<Blog, Tab1Adapter.ViewHolder>(this) {

    companion object : DiffUtil.ItemCallback<Blog>() {
        override fun areItemsTheSame(oldItem: Blog, newItem: Blog) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Blog, newItem: Blog) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Tab1Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tab4, parent, false)
        return Tab1Adapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Tab1Adapter.ViewHolder, position: Int) {
        val item = getItem(position)
        val itemView = holder.itemView
        itemView.findViewById<TextView>(R.id.item_name).text = item.title
        val imgResID = itemView.resources.getIdentifier(item.imgUrl,"drawable",itemView.context.packageName)
        Glide.with(holder.itemView.context).load(imgResID).into(itemView.findViewById(R.id.item_image))
        itemView.findViewById<ImageView>(R.id.item_image).setOnClickListener {
            val action = Tab4FragmentDirections.actionTab4FragmentToBlogPageFragment(item)
            itemView.findNavController()
                .navigate(action)
        }
    }
}