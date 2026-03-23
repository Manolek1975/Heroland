package com.delek.heroland.ui.tile

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.createBitmap
import androidx.core.graphics.drawable.toDrawable
import androidx.core.graphics.scale
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.R.color
import com.delek.heroland.R.drawable
import com.delek.heroland.R.string
import com.delek.heroland.databinding.FragmentTileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Field
import kotlin.getValue


@AndroidEntryPoint
open class TileFragment : Fragment() {
    private var _binding: FragmentTileBinding? = null
    private val binding get() = _binding!!
    private val args: TileFragmentArgs by navArgs()
    private lateinit var data: SharedPreferences
    private val viewModel: TileViewModel by viewModels()
    private var w: Int = 210

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
    }

    private fun initUI() {
        placeChits()
        placePhases()
        arrowBack()
    }

    private fun placeChits() {
        viewModel.getTileById(args.id)
        viewModel.tile.observe(viewLifecycleOwner) { tile ->
            data.edit { putInt("location", 5) }
            binding.tileName.text = tile.name
            val id = getResId(tile.image, drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            placeClearings(tile.type)
            placeAdviceChit(tile.advice, tile.type.first())
            if (tile.sound > 0) placeSoundChit(tile.sound)
        }
    }

    private fun placeAdviceChit(id: Int, type: Char) {
        val dwelling = data.getInt("start_dwelling", 0)
        viewModel.getAdviceChitById(id)
        viewModel.advice.observe(viewLifecycleOwner) { advice ->
            binding.adviceChit.text = getString(string.advice_chit, advice.name, type)
            if (advice.dwelling == dwelling) placePlayer()
            if (advice.dwelling > 0) placeDwelling(advice.dwelling)
            //if (advice.monster > 0) placeAdviceMonster(advice.monster)
        }
    }

    private fun placeSoundChit(id: Int) {
        viewModel.getSoundChitById(id)
        viewModel.sound.observe(viewLifecycleOwner) { sound ->
            binding.soundChit.visibility = View.VISIBLE
            binding.soundChit.text = getString(string.advice_chit, sound.name, sound.num.toString())
            if (sound.type == "T" || sound.type == "L") {
                binding.soundChit.backgroundTintList =
                    ResourcesCompat.getColorStateList(resources, color.gold, null)
                //placeTreasureLocations(sound.treasure, sound.num)
            }
            //if (sound.monster > 0) placeSoundMonster(sound.monster, sound.num)
        }
    }

    private fun placeDwelling(advice: Int) {
        val start = data.getInt("start_dwelling", 0)
        viewModel.getDwellingById(advice)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            val dwellingId = getResId(dwelling.image, drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, dwellingId)
            binding.c5.background = bitmap.toDrawable(resources)
            if (dwelling.id == start) binding.c5.translationY = 220f
            binding.c5.setOnClickListener {
                findNavController().navigate(
                    TileFragmentDirections.actionNavTileToNavDwelling(dwelling.id)
                )
            }
        }
    }

    private fun placePlayer() {
        val roleId = data.getInt("role_id", 0)
        viewModel.getRoleById(roleId)
        viewModel.role.observe(viewLifecycleOwner) { role ->
            val id = getResId(role.image, drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, id)
            val scale = bitmap.scale(w, w, false)
            val image = scale.toDrawable(resources)
            binding.player.background = image
            binding.player.visibility = View.VISIBLE
        }
        binding.player.setOnClickListener {
            binding.rvPhases.visibility = View.VISIBLE
        }
    }

    fun placePhases(){
        val day = data.getInt("day", 0)
        viewModel.getPhases()
        val phaseAdapter = PhaseAdapter(onItemSelected = {
            binding.rvPhases.visibility = View.GONE
            viewModel.insertDayPhase(1, it.id)
            println("Day: $day Phase: ${it.name}")

        })
        binding.rvPhases.layoutManager = GridLayoutManager(context, 4)
        binding.rvPhases.adapter = phaseAdapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.phases.observe(viewLifecycleOwner) {
                    phaseAdapter.updateList(it)
                }
            }
        }
    }

    private fun drawConnections() {
        val width = binding.c2.width
        val w = binding.con1.width - width * 2
        val h = binding.con1.height
        println(width)
        val bitmap = createBitmap(w, h)
        val canvas = Canvas(bitmap)
        val paint = Paint().apply {
            color = Color.YELLOW
            strokeWidth = 5f
        }
        canvas.drawLine(0f, h / 2f, w.toFloat(), h / 2f, paint)
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
        binding.con1.setImageBitmap(bitmap)
        binding.con2.setImageBitmap(bitmap)
    }

    private fun placeClearings(type: String) {
        when (type) {
            "VALLEY" -> {
                binding.c3.visibility = View.GONE
                binding.c6.visibility = View.GONE
                //drawConnections()
            }
            "WOOD" -> {
                binding.c1.visibility = View.GONE
                binding.c3.visibility = View.GONE
                binding.c6.visibility = View.GONE
            }
        }
    }

    private fun arrowBack() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigate(
                TileFragmentDirections.actionNavTileToNavMap()
            )
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

