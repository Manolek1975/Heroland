package com.delek.heroland.ui.tileMap

import android.graphics.drawable.ScaleDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentTileMapBinding
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
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
            val id = getResId(tile.image, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
        }

        for (i in 1..45) {
            val b = ContextThemeWrapper(requireContext(), R.style.Base_Theme_Box_Layout)
            val button = MaterialTextView(b)
            binding.boxLayout.addView(button)
        }

        binding.boxLayout.getChildAt(30).setOnClickListener {
            val id = getResId("img_amazon", R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            ScaleDrawable(bg, 0, 0.01f, 0.01f)
            //val scale = Bitmap.createScaledBitmap(bg, 80, 80, false)
            binding.boxLayout.getChildAt(30).background = bg
            println("Click")
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