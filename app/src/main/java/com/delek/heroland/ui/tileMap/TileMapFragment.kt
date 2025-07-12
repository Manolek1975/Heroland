package com.delek.heroland.ui.tileMap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentTileMapBinding
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Field


@AndroidEntryPoint
class TileMapFragment : Fragment() {

    private var _binding: FragmentTileMapBinding? = null
    private val binding get() = _binding!!
    private val args: TileMapFragmentArgs by navArgs()
    private val viewmodel: TileMapViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTileMapBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getTileById(args.id)
        viewmodel.tile.observe(viewLifecycleOwner) { tile ->
            binding.tileName.text = tile.name
            val type = tile.type.first()
            binding.adviceChit.text = getString(R.string.advice_chit, tile.advice, type)
            if (tile.sound.isNotEmpty()) {
                val rnd = (1..45).random()
                binding.soundChit.visibility = View.VISIBLE
                binding.soundChit.text = getString(R.string.sound_chit, tile.sound)
/*                val soundChit = binding.soundChit.background.toBitmap()
                //soundChit[200, 200] = Color.RED
                val scale = Bitmap.createScaledBitmap(soundChit, 150, 150, false)
                val image = BitmapDrawable(resources, scale)
                binding.boxLayout.getChildAt(rnd).background = image*/
            }
            val id = getResId(tile.image, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
        }
        //Set Boxes
        for (i in 1..45) {
            val b = ContextThemeWrapper(requireContext(), R.style.Base_Theme_Box_Layout)
            val box = MaterialTextView(b)
            binding.boxLayout.addView(box)
        }
        //Set Player
        val data = context?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val roleId = data?.getInt("roleId", 0)
        viewmodel.getRoleById(roleId!!)
        lifecycleScope.launch {
            viewmodel.role.observe(viewLifecycleOwner) { role ->
                val id = getResId(role.image, R.drawable::class.java)
                val bitmap = BitmapFactory.decodeResource(resources, id)
                val scale = Bitmap.createScaledBitmap(bitmap, 210, 210, false)
                val image = BitmapDrawable(resources, scale)
                binding.boxLayout.getChildAt(22).background = image
            }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}