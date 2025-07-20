package com.delek.heroland.ui.tileMap

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver.OnGlobalLayoutListener
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentTileMapBinding
import com.delek.heroland.databinding.LayoutDataBinding
import com.google.android.material.textview.MaterialTextView
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Field


@AndroidEntryPoint
class TileMapFragment : Fragment() {

    private var _binding: FragmentTileMapBinding? = null
    private val binding get() = _binding!!
    private val viewmodel: TileMapViewModel by viewModels()
    private val args: TileMapFragmentArgs by navArgs()
    private lateinit var data: SharedPreferences
    private var w: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTileMapBinding.inflate(inflater, container, false)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        side()
        binding.arrowBack.setOnClickListener {
            findNavController().navigate(
                TileMapFragmentDirections.actionNavTileMapToNavMap()
            )
        }
    }

    private fun initUI() {
        initBoxes()
        viewmodel.getTileById(args.id)
        viewmodel.tile.observe(viewLifecycleOwner) { tile ->
            binding.tileName.text = tile.name
            val id = getResId(tile.image, R.drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            placeAdviceChit(tile.advice, tile.type.first())
            if (tile.sound > 0) {
                placeSoundChit(tile.sound)
            }
        }
    }

    private fun initBoxes() {
        for (i in 1..45) {
            val style = ContextThemeWrapper(requireContext(), R.style.box_cell)
            val box = MaterialTextView(style)
            binding.boxLayout.addView(box)
        }
    }

    private fun placeAdviceChit(id: Int, type: Char) {
        val dwelling = data.getInt("start_dwelling", 0)
        viewmodel.getAdviceChitById(id)
        viewmodel.advice.observe(viewLifecycleOwner) { advice ->
            binding.adviceChit.text = getString(R.string.advice_chit, advice.name, type)
            if(advice.dwelling == dwelling){
                placePlayer()
            }
            if(advice.dwelling > 0) {
                placeDwelling(advice.dwelling)
            }
        }
    }

    private fun placeDwelling(advice: Int) {
        viewmodel.getDwellingById(advice)
        viewmodel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            val dwellingId = getResId(dwelling.image, R.drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, dwellingId)
            val layout = fillDataAndGetBitmap(bitmap, dwelling.name)
            val scale = Bitmap.createScaledBitmap(layout, w, w, false)
            val image = BitmapDrawable(resources, scale)
            binding.boxLayout.getChildAt(32).background = image
            binding.boxLayout.getChildAt(32).setOnClickListener {
                findNavController().navigate(
                    TileMapFragmentDirections.actionNavTileMapToMapDwelling(dwelling.id)
                )
            }
        }

    }

    private fun placeSoundChit(id: Int) {
        viewmodel.getSoundChitById(id)
        viewmodel.sound.observe(viewLifecycleOwner) { sound ->
            binding.soundChit.visibility = View.VISIBLE
            binding.soundChit.text =
                getString(R.string.advice_chit, sound.name, sound.num.toString())
            if (sound.type == "T" || sound.type == "L") {
                binding.soundChit.backgroundTintList =
                    ResourcesCompat.getColorStateList(resources, R.color.gold, null)
                placeTreasureLocations(sound.treasure, sound.num)
            }
            binding.boxLayout.getChildAt(6).setOnClickListener {
                findNavController().navigate(
                    TileMapFragmentDirections.actionNavTileMapToMapDwelling(sound.treasure)
                )
            }
        }
    }

    private fun placeTreasureLocations(treasure: Int, num: Int) {
        viewmodel.getDwellingById(treasure)
        viewmodel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            val dwellingId = getResId(dwelling.image, R.drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, dwellingId)
            val layout = fillDataAndGetBitmap(bitmap, dwelling.name)
            val scale = Bitmap.createScaledBitmap(layout, w, w, false)
            val image = BitmapDrawable(resources, scale)
            binding.boxLayout.getChildAt(num*6).background = image
        }
    }

    private fun placePlayer() {
        val roleId = data.getInt("role_id", 0)
        viewmodel.getRoleById(roleId)
        viewmodel.role.observe(viewLifecycleOwner) { role ->
            val id = getResId(role.image, R.drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, id)
            val scale = Bitmap.createScaledBitmap(bitmap, w, w, false)
            val image = BitmapDrawable(resources, scale)
            binding.boxLayout.getChildAt(22).background = image
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
        layout.measure(
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
            View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
        )
        layout.layout(0, 0, layout.measuredWidth, layout.measuredHeight)
        val bitmap = Bitmap.createBitmap(
            layout.measuredWidth,
            layout.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
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

    private fun side() {
        val cell = binding.boxLayout.getChildAt(0)
        val vto = cell.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                cell.viewTreeObserver
                w = cell.measuredWidth
                cell.viewTreeObserver.removeOnGlobalLayoutListener(this)
                println(w)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}

/*        val dm: DisplayMetrics = resources.displayMetrics
        val x = dm.widthPixels
        val w = (x / 5) - 20 //margin 8*2 + width stroke 2*2
        val t = 2F*/