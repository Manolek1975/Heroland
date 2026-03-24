package com.delek.heroland.ui.phases

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemPhaseBinding
import com.delek.heroland.domain.model.DayPhase

class DayPhaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemPhaseBinding.bind(view)

    fun render(dayPhase: DayPhase, onItemSelected: (DayPhase) -> Unit) {
        binding.tvPhase.text = dayPhase.phase

        binding.tvPhase.setOnClickListener {
            exitPhase(binding.tvPhase, goPhase = { onItemSelected(dayPhase) })
        }
    }

    private fun exitPhase(view: View, goPhase:()->Unit ) {
        goPhase()
    }
}