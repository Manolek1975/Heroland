package com.delek.heroland.ui.options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemVpButtonBinding
import com.delek.heroland.domain.model.VictoryPoints

class VictoryPointsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemVpButtonBinding.bind(view)

    fun render(vp: VictoryPoints){

        binding.tvName.text = vp.name
        binding.tvValue.text = String.format(vp.treasures.toString())

    }
}