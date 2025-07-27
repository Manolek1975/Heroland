package com.delek.heroland.ui.dwelling

import android.graphics.Color
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemGroupBinding
import com.delek.heroland.domain.model.Group
import com.delek.heroland.ui.dwelling.GroupAdapter.Companion.selected

class GroupViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemGroupBinding.bind(view)
    val context = binding.tvGroup.context!!

    fun render(group: Group, onItemSelected: (Group) -> Unit) {
        binding.tvGroup.text = group.name

        if (selected != adapterPosition) {
            binding.tvGroup.background = ContextCompat.getDrawable(context, R.drawable.layout_group_unselected)
            binding.tvGroup.setTextColor(ContextCompat.getColor(context, R.color.primary))
        } else {
            binding.tvGroup.background = ContextCompat.getDrawable(context, R.drawable.layout_group_selected)
            binding.tvGroup.setTextColor(Color.WHITE)
        }

        binding.tvGroup.text = group.name

        binding.tvGroup.setOnClickListener {
            selected = adapterPosition
            onItemSelected(group)
        }
    }
}