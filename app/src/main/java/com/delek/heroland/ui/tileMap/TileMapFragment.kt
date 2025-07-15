package com.delek.heroland.ui.tileMap

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentTileMapBinding
import com.delek.heroland.databinding.LayoutDataBinding
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
        //Set Boxes
        for (i in 1..45) {
            val style = ContextThemeWrapper(requireContext(), R.style.Base_Theme_Box_Layout)
            val box = MaterialTextView(style)
            binding.boxLayout.addView(box)
        }
        val dm: DisplayMetrics = resources.displayMetrics
        val x = dm.widthPixels
        val w = (x / 5) - 20 //margin 8*2 + width stroke 2*2
        val t = 2F
        //Set Tile
        viewmodel.getTileById(args.id)
        viewmodel.tile.observe(viewLifecycleOwner) { tile ->
            binding.tileName.text = tile.name
            val type = tile.type.first()
            binding.adviceChit.text = getString(R.string.advice_chit, tile.advice, type)
            val id = getResId(tile.image, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            if (tile.sound.isNotEmpty()) {
                binding.soundChit.visibility = View.VISIBLE
                binding.soundChit.text = getString(R.string.sound_chit, tile.sound)
            }
            if (tile.dwelling != 0) {
            viewmodel.getDwellingById(tile.dwelling)
            viewmodel.dwelling.observe(viewLifecycleOwner) { dwelling ->
                    val idDwelling = getResId(dwelling.image, R.drawable::class.java)
                    val bitmap = BitmapFactory.decodeResource(resources, idDwelling)
                    val layout = fillDataAndGetBitmap(bitmap, dwelling.name)
                    val scale = Bitmap.createScaledBitmap(layout, w, w, false)
                    val image = BitmapDrawable(resources, scale)
                    binding.boxLayout.getChildAt(6).background = image
                    binding.boxLayout.getChildAt(6).translationX = t+2
                    binding.boxLayout.getChildAt(6).translationY = t
                }
            }
            binding.boxLayout.getChildAt(6).setOnClickListener {
                findNavController().navigate(
                    TileMapFragmentDirections.actionNavTileMapToMapDwelling(tile.dwelling)
                )
            }
        }
        //Set Player
        val data = context?.getSharedPreferences("data", Context.MODE_PRIVATE)
        val roleId = data?.getInt("roleId", 0)
        viewmodel.getRoleById(roleId!!)
        lifecycleScope.launch {
            viewmodel.role.observe(viewLifecycleOwner) { role ->
                val id = getResId(role.image, R.drawable::class.java)
                val bitmap = BitmapFactory.decodeResource(resources, id)
                val scale = Bitmap.createScaledBitmap(bitmap, w, w, false)
                val image = BitmapDrawable(resources, scale)
                binding.boxLayout.getChildAt(22).background = image
/*              binding.boxLayout.getChildAt(22).translationX = 12F
                binding.boxLayout.getChildAt(22).translationY = 12F*/
            }
        }
        binding.boxLayout.getChildAt(22).setOnClickListener {
            findNavController().navigate(
                TileMapFragmentDirections.actionNavTileMapToNavCharacter(roleId)
            )
        }
    }

    private fun fillDataAndGetBitmap(image: Bitmap, title: String): Bitmap {
        val layoutInflater: LayoutInflater = LayoutInflater.from(requireContext())
        val layoutDataBinding = LayoutDataBinding.inflate(layoutInflater, null, false)
        // Fill in your image data into layout
        layoutDataBinding.ivBackground.setImageBitmap(image)
        layoutDataBinding.tvCenterText.text = title
        // Get Bitmap of your layout
        val outputBitmap = getBitmapFromView(layoutDataBinding.root)
        return outputBitmap
    }

    private fun getBitmapFromView(layout: View): Bitmap {
        layout.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
        layout.layout(0, 0, layout.measuredWidth, layout.measuredHeight)
        val bitmap = Bitmap.createBitmap(layout.measuredWidth, layout.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        layout.layout(layout.left, layout.top, layout.right, layout.bottom)
        layout.draw(canvas)
        return bitmap
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