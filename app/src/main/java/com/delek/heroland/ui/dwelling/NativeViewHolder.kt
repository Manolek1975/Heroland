package com.delek.heroland.ui.dwelling

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.core.Game
import com.delek.heroland.databinding.ItemNativeBinding
import com.delek.heroland.domain.model.Native
import com.delek.heroland.ui.dwelling.NativeAdapter.Companion.alerted


class NativeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNativeBinding.bind(view)

    fun render(native: Native, onItemSelected: (Native) -> Unit){
        val id = Game().getResId(native.image, R.drawable::class.java)
        binding.ivNative.setImageResource(id)
        binding.nameNative.text = native.name
        if (alerted) {
            binding.fightA.text = native.fightB
            binding.moveA.text = String.format("%s", native.moveB)
            setGroupColorDark(native.groupId)
        } else {
            binding.fightA.text = native.fightA
            binding.moveA.text = String.format("%s", native.moveA)
            setGroupColor(native.groupId)
        }
        binding.ivColor.setOnClickListener {
            alerted = !alerted
            flipNative(binding.ivNative, goNative = {onItemSelected(native)})
        }
    }

    private fun setGroupColorDark(group: Int) {
        val context = binding.ivColor.context
        when (group) {
            1 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.bashkars_dark))
            2 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.company_dark))
            3 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.guard_dark))
            4 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.lancers_dark))
            5 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.order_dark))
            6 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.patrol_dark))
            7 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.rogues_dark))
            8 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.soldiers_dark))
            9 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.woodfolk_dark))
        }
    }

    private fun setGroupColor(group: Int){
        val context = binding.ivColor.context
        when (group) {
            1 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.bashkars))
            2 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.company))
            3 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.guard))
            4 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.lancers))
            5 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.order))
            6 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.patrol))
            7 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.rogues))
            8 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.soldiers))
            9 -> binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.woodfolk))
        }
    }

    private fun flipNative(view: View, goNative:()->Unit ) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            withEndAction { goNative() }
            start()
        }
    }


}