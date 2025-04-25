package com.delek.heroland.ui.options

import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemTypeBinding
import com.delek.heroland.domain.model.StartSpell
import com.delek.heroland.ui.options.TypeAdapter.Companion.selected

class TypeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemTypeBinding.bind(view)
    val context = binding.itemType.context!!

    fun render(type: StartSpell, onItemSelected: (StartSpell) -> Unit) {

        if (selected != -1) {
            if (selected == adapterPosition) {
                binding.tvType.background = ContextCompat.getDrawable(context, R.drawable.layout_selected)
                binding.tvType.setTextColor(Color.WHITE)
            } else {
                binding.tvType.background = ContextCompat.getDrawable(context, R.drawable.layout_unselected)
                binding.tvType.setTextColor(ContextCompat.getColor(context, R.color.primary))
            }
        }

        binding.tvType.text = type.spellType

        binding.itemType.setOnClickListener {
            selected = adapterPosition
            onItemSelected(type)
        }
    }

}