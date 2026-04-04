package com.delek.heroland.ui.tile

import android.content.Context
import android.content.SharedPreferences
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
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
import com.delek.heroland.core.Game
import com.delek.heroland.core.Phase
import com.delek.heroland.databinding.FragmentTileBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
open class TileFragment : Fragment() {
    private var _binding: FragmentTileBinding? = null
    private val binding get() = _binding!!
    private val args: TileFragmentArgs by navArgs()
    private lateinit var data: SharedPreferences
    private val viewModel: TileViewModel by viewModels()
    private var w: Int = 220

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
        arrowBack()
        placeChits()
        placePhases()
    }

    private fun arrowBack() {
        binding.arrowBack.setOnClickListener {
            findNavController().navigate(
                TileFragmentDirections.actionNavTileToNavMap()
            )
        }
    }

    private fun placeChits() {
        viewModel.getTileById(args.id)
        viewModel.tile.observe(viewLifecycleOwner) { tile ->
            binding.tileName.text = tile.name
            val id = Game().getResId(tile.image, drawable::class.java)
            val bg = ContextCompat.getDrawable(requireContext(), id)
            binding.root.background = bg
            placeClearings(tile.type)
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
            val dwellingId = Game().getResId(dwelling.image, drawable::class.java)
            val bitmap = BitmapFactory.decodeResource(resources, dwellingId)
            binding.lyValley.dwelling.background = bitmap.toDrawable(resources)
            if (dwelling.id == start) binding.lyValley.dwelling.translationX = 220f
            binding.lyValley.dwelling.setOnClickListener {
                findNavController().navigate(
                    TileFragmentDirections.actionNavTileToNavDwelling(dwelling.id)
                )
            }
        }
    }

    private fun placePlayer() {
        val roleId = data.getInt("role_id", 0)
        viewModel.getPlayerByRole(roleId)
        viewModel.player.observe(viewLifecycleOwner) { player ->
            val clearing = (player.clearing)
            viewModel.getRoleById(roleId)
            val (x, y) = coordinates(clearing)
            viewModel.role.observe(viewLifecycleOwner) { role ->
                val id = Game().getResId(role.image, drawable::class.java)
                val bitmap = BitmapFactory.decodeResource(resources, id)
                val scale = bitmap.scale(w, w, false)
                val image = scale.toDrawable(resources)
                binding.player.x = x.toFloat()
                binding.player.y = y.toFloat()
                binding.player.background = image
                binding.player.visibility = View.VISIBLE
            }
        }
        binding.player.setOnClickListener {
            binding.rvPhases.visibility = View.VISIBLE
        }
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

    fun placePhases() {
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
        val dices = dice.rollImages()
        binding.diceW.setBackgroundResource(dices.first)
        binding.diceR.setBackgroundResource(dices.second)
        binding.diceW.visibility = View.VISIBLE
        binding.diceR.visibility = View.VISIBLE
        when (id) {
            1 -> phaseHide(result)
            2 -> phaseMove()
        }
    }

    fun phaseHide(result: Boolean) {
        if (result)
            binding.player.background.colorFilter = android.graphics.PorterDuffColorFilter(
                Color.GRAY, PorterDuff.Mode.MULTIPLY
            )
    }

    fun phaseMove(){
        binding.diceW.visibility = View.GONE
        binding.diceR.visibility = View.GONE
        binding.toClearing1.visibility = View.VISIBLE
        binding.toClearing2.visibility = View.VISIBLE

        val role = data.getInt("role_id", 0)
        viewModel.getPlayerByRole(role)
        viewModel.player.observe(viewLifecycleOwner){ player ->
            viewModel.getClearingByLocation(player.tile, player.clearing)
            viewModel.clearing.observe(viewLifecycleOwner){ clearing ->
                binding.toClearing1.text = clearing.con1
                binding.toClearing2.text = clearing.con2
                binding.toClearing1.setOnClickListener {
                    val num = clearing.con1.first()
                    viewModel.updateLocation(clearing.tile, num.digitToInt(), role)
                    placePlayer()
                    binding.toClearing1.visibility = View.GONE
                    binding.toClearing2.visibility = View.GONE
                }
                binding.toClearing2.setOnClickListener {
                    viewModel.updateLocation(clearing.tile, clearing.clearing, role)
                    placePlayer()
                    binding.toClearing1.visibility = View.GONE
                    binding.toClearing2.visibility = View.GONE
                }
            }
        }

    }

    fun coordinates(clearing: Int): Pair<Int, Int>{
        val point = IntArray(2)
        when(clearing){
            1 -> binding.lyValley.c1.getLocationOnScreen(point)
            2 -> binding.lyValley.c2.getLocationOnScreen(point)
            4 -> binding.lyValley.c4.getLocationOnScreen(point)
            5 -> binding.lyValley.c5.getLocationOnScreen(point)
        }
        val (x, y) = point
        return Pair(x, y)

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

}


