package com.delek.heroland.ui.tileMap

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemTypeBinding
import com.delek.heroland.domain.model.Phase

class PhaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTypeBinding.bind(view)

    fun render(phase: Phase, onItemSelected: (Phase) -> Unit) {
        binding.tvType.text = phase.name

        /*
                binding.itemRole.setOnClickListener {
                    flipRole(binding.ivRole, goRole = {onItemSelected(role)})
                }
        */
    }
}