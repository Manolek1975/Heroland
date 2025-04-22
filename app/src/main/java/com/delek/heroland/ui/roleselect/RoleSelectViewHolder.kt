package com.delek.heroland.ui.roleselect

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.delek.heroland.R
import com.delek.heroland.databinding.ItemRoleBinding
import com.delek.heroland.domain.model.Role
import java.lang.reflect.Field

class RoleSelectViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemRoleBinding.bind(view)

    fun render(role: Role, onItemSelected: (Role) -> Unit) {
        binding.tvName.text = role.name
        val id = getResId(role.image, R.drawable::class.java)
        binding.ivRole.setImageResource(id)

        binding.itemRole.setOnClickListener {
            flipRole(binding.ivRole, goRole = {onItemSelected(role)})
        }

    }

    private fun flipRole(view: View, goRole:()->Unit ) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationYBy(360f)
            withEndAction { goRole() }
            start()
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