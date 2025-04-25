package com.delek.heroland.ui.options

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.databinding.ItemVpButtonBinding
import com.delek.heroland.domain.model.VictoryPoints
import com.delek.heroland.ui.options.VictoryPointsAdapter.Companion.total
import com.delek.heroland.ui.options.VictoryPointsAdapter.Companion.vpValues


class VictoryPointsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemVpButtonBinding.bind(view)

    fun render(vp: VictoryPoints, onItemSelected: (Int) -> Unit){

        binding.tvName.text = vp.name
        binding.tvValue.text = String.format(0.toString())

        binding.ibRight.setOnClickListener {
            if (total < 5) {
                vpValues[adapterPosition]++
                total = vpValues.sum()
                println("List: $vpValues, Total: $total")
                binding.tvValue.text = String.format(vpValues[adapterPosition].toString())
            }
            onItemSelected(total)
        }

        binding.ibLeft.setOnClickListener {
            if (vpValues[adapterPosition] != 0){
                vpValues[adapterPosition]--
                total = vpValues.sum()
                println("List: $vpValues, Total: $total")
                binding.tvValue.text = String.format(vpValues[adapterPosition].toString())
            }
            onItemSelected(total)
        }
    }

}