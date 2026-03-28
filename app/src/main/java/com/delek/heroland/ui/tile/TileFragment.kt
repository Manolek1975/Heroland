package com.delek.heroland.ui.tile

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.edit
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
import com.delek.heroland.R.drawable
import com.delek.heroland.R.string
import com.delek.heroland.core.Dice
import com.delek.heroland.core.Phase
import com.delek.heroland.databinding.FragmentTileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Field


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
            binding.lyValley.c5.post {
                val point = IntArray(2)
                binding.lyValley.c5.getLocationOnScreen(point)
                val (x, y) = point
                data.edit { putInt("posX", x) }
                data.edit { putInt("posY", y) }
                println("x: $x, y:$y")
            }
            placeAdviceChit(tile.advice, tile.type.first())
            //if (tile.sound > 0) placeSoundChit(tile.sound)

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

    /*    private fun placeSoundChit(id: Int) {
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
        }*/

    private fun placeDwelling(advice: Int) {
        val start = data.getInt("start_dwelling", 0)
        viewModel.getDwellingById(advice)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            val dwellingId = getResId(dwelling.image, drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, dwellingId)
            binding.lyValley.dwelling.background = bitmap.toDrawable(resources)
            if (dwelling.id == start) binding.lyValley.dwelling.translationY = 220f
            binding.lyValley.dwelling.setOnClickListener {
                findNavController().navigate(
                    TileFragmentDirections.actionNavTileToNavDwelling(dwelling.id)
                )
            }
        }
    }

    private fun placePlayer() {
        val x = data.getInt("posX", 0)
        val y = data.getInt("posY", 0)
        val padding = 40f //Padding apply for clearing in themes
        val roleId = data.getInt("role_id", 0)
        viewModel.getRoleById(roleId)
        viewModel.role.observe(viewLifecycleOwner) { role ->
            val id = getResId(role.image, drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, id)
            val scale = bitmap.scale(w, w, false)
            val image = scale.toDrawable(resources)
            binding.player.x = x - padding*2
            binding.player.y = y - padding
            binding.player.background = image
            binding.player.visibility = View.VISIBLE
        }
        binding.player.setOnClickListener {
            binding.rvPhases.visibility = View.VISIBLE
        }
    }

    fun placePhases() {
        val day = data.getInt("day", 0)
        viewModel.getPhases()
        val phaseAdapter = PhaseAdapter(onItemSelected = {
            binding.rvPhases.visibility = View.GONE
            //viewModel.insertDayPhase(day, it.name)
            playPhase(it.id)
        })
        binding.rvPhases.layoutManager = GridLayoutManager(context, 6)
        binding.rvPhases.adapter = phaseAdapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.phases.observe(viewLifecycleOwner) {
                    phaseAdapter.updateList(it)
                }
            }
        }
    }

    private fun playPhase(id: Int) {
        val phase = Phase(id)
        val dice = Dice()

        val result = phase.getPhase(id, dice.rollDice())
        when (id){
            1-> phaseHide(result)

        }

        val dices = dice.rollImages()
        binding.diceW.setBackgroundResource(dices.first)
        binding.diceR.setBackgroundResource(dices.second)
        binding.diceW.visibility = View.VISIBLE
        binding.diceR.visibility = View.VISIBLE

    }

    fun phaseHide(result: Boolean) {
        if(result)
            binding.player.background.setColorFilter(
                Color.GRAY,
                android.graphics.PorterDuff.Mode.MULTIPLY
            )

    }

    private fun placeClearings(type: String) {
        when (type) {
            "VALLEY" -> {
                binding.lyValley.layoutValley.visibility = View.VISIBLE
            }
            "WOOD" -> {
                binding.lyWood.layoutValley.visibility = View.VISIBLE
            }
            "MOUNTAIN" -> {
                binding.lyMountain.layoutValley.visibility = View.VISIBLE
            }
            "CAVE" -> {
                binding.lyCave.layoutValley.visibility = View.VISIBLE
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

    /*    private fun drawConnections() {
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
}*/

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


