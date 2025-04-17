package com.delek.heroland.ui.detail

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemChitBinding
import com.delek.heroland.domain.model.Chit
import java.util.Locale

class ChitViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemChitBinding.bind(view)

    fun render(chit: Chit) {
        binding.tvName.text = chit.name
        binding.tvType.text = chit.type
        binding.tvSpeed.text = String.format(Locale.getDefault(), "%d", chit.speed)
        binding.tvEffort.text = chit.effort

    }
}