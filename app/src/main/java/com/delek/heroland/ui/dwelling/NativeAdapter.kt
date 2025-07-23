package com.delek.heroland.ui.dwelling

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Native
import javax.inject.Inject

class NativeAdapter @Inject constructor(
    private var nativeList: List<Native> = emptyList(),
    private val onItemSelected: (Native) -> Unit) :
    RecyclerView.Adapter<NativeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NativeViewHolder {
        return NativeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_native, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NativeViewHolder, position: Int) {
        holder.render(nativeList[position], onItemSelected)
    }

    override fun getItemCount(): Int = nativeList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Native>) {
        nativeList = list
        notifyDataSetChanged()
    }

}