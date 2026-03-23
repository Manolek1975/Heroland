package com.delek.heroland.ui.tile

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.Phase

class PhaseAdapter(
    private var phaseList: List<Phase> = emptyList(),
    private val onItemSelected: (Phase) -> Unit):
    RecyclerView.Adapter<PhaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhaseViewHolder {
        return PhaseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_phase, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhaseViewHolder, position: Int) {
        holder.render(phaseList[position], onItemSelected)
    }

    override fun getItemCount(): Int = phaseList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(list: List<Phase>){
        phaseList = list
        notifyDataSetChanged()
    }

}