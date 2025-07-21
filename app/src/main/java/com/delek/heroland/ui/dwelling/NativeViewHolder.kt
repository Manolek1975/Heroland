package com.delek.heroland.ui.dwelling

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemNativeBinding
import com.delek.heroland.domain.model.Native


class NativeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNativeBinding.bind(view)

    fun render(native: Native){
        val context = binding.ivColor.context
        if (native.group == 3) {
            binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.guard))
        } else {
            binding.ivColor.setBackgroundColor(ContextCompat.getColor(context, R.color.woodfolk))
        }

        //binding.ivNative.setImageResource(native.image)

    }


}