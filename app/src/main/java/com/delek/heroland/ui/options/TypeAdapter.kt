package com.delek.heroland.ui.options

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.domain.model.StartSpell


class TypeAdapter(
    private var typesList: List<StartSpell> = emptyList(),
    private val onItemSelected: (StartSpell) -> Unit)
: RecyclerView.Adapter<TypeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeViewHolder {
        return TypeViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_type, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TypeViewHolder, position: Int) {
        holder.render(typesList[position], onItemSelected)
    }

    override fun getItemCount(): Int = typesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateTypes(type: List<StartSpell>){
        typesList = type
        notifyDataSetChanged()
    }

}