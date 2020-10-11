package com.example.acinema.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.acinema.R
import com.example.acinema.data.model.CinemaSearchItemModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler.view.*

class RecyclerViewAdapter: androidx.recyclerview.widget.ListAdapter<CinemaSearchItemModel,Vholder>(DiffUtilCalback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent,false)
        return Vholder(view)

    }

    override fun onBindViewHolder(holder: Vholder, position: Int) {
        holder.bind(getItem(position))

    }

}

class DiffUtilCalback : DiffUtil.ItemCallback<CinemaSearchItemModel >(){
    override fun areItemsTheSame(oldItem: CinemaSearchItemModel , newItem: CinemaSearchItemModel ): Boolean {
        return  oldItem.hashCode() == newItem.hashCode()
    }

    override fun areContentsTheSame(oldItem: CinemaSearchItemModel , newItem: CinemaSearchItemModel ): Boolean {
        return oldItem.id == newItem.id
                && oldItem.title  == newItem.title
                && oldItem.year == newItem.year
                && oldItem.poster  == newItem.poster
    }

}


class Vholder(view: View) : RecyclerView.ViewHolder(view){
    fun bind(item: CinemaSearchItemModel) {
        itemView.tvFirstRecycler.text = item.title
        itemView.tvSecondRecycler.text = item.year
        Picasso.get().load(item.poster).into(itemView.img )
    }
}