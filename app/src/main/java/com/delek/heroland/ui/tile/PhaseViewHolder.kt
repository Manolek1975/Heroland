package com.delek.heroland.ui.tile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemPhaseBinding
import com.delek.heroland.domain.model.Phase

class PhaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPhaseBinding.bind(view)

    fun render(phase: Phase, onItemSelected: (Phase) -> Unit) {
        binding.tvPhase.text = phase.name

        binding.tvPhase.setOnClickListener {
            selectedPhase(binding.tvPhase, goPhase = { onItemSelected(phase) })
        }
    }

    private fun selectedPhase(view: View, goPhase:()->Unit ) {
        goPhase()
    }
}