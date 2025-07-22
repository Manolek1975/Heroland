package com.delek.heroland.ui.dwelling

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemNativeBinding
import com.delek.heroland.domain.model.Native
import java.lang.reflect.Field


class NativeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemNativeBinding.bind(view)

    fun render(native: Native){

        setGroupColor(native.groupId)
        val id = getResId(native.image, R.drawable::class.java)
        binding.ivNative.setImageResource(id)
        binding.nameNative.text = native.name
        binding.fightA.text = native.fightA
        binding.moveA.text = String.format("%s", native.moveA)

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

    private fun getResId(resName: String?, c: Class<*>): Int {
        try {
            val idField: Field = c.getDeclaredField(resName!!)
            return idField.getInt(idField)
        } catch (e: Exception) {
            e.printStackTrace()
            return -1
        }
    }


}