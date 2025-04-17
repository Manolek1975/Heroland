package com.delek.heroland.ui.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Chit


class ChitAdapter(private var chitList: List<Chit> = emptyList()): RecyclerView.Adapter<ChitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChitViewHolder {
        return ChitViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_chit, parent, false)
        )
    }

    override fun getItemCount(): Int = chitList.size

    override fun onBindViewHolder(holder: ChitViewHolder, position: Int) {
        holder.render(chitList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Chit>){
        chitList = list
        notifyDataSetChanged()
    }
}