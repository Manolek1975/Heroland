package com.delek.heroland.ui.options

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentOptionsBinding
import com.delek.heroland.domain.model.Dwelling
import com.delek.heroland.domain.model.Spell
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OptionsFragment : Fragment() {

    private var _binding: FragmentOptionsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: OptionsViewModel by viewModels()
    private val args: OptionsFragmentArgs by navArgs()
    private lateinit var typeAdapter: TypeAdapter
    private lateinit var spellAdapter: SpellAdapter
    private lateinit var vpAdapter: VictoryPointsAdapter
    private var numSpells: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOptionsBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        initHeader()
        initDwellings()
        initSpells()
        initVictoryPoints()

    }

    private fun initHeader() {
        viewModel.getRole(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.role.observe(viewLifecycleOwner) {
                    binding.headOptions.text = getString(R.string.options_head, it.name)
                }
            }
        }
    }

    private fun initDwellings() {
        viewModel.getDwellingsByRole(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dwelling.observe(viewLifecycleOwner) {
                    setDwellingRadioGroup(it)
                }
            }
        }
    }

    private fun setDwellingRadioGroup(dwelling: List<Dwelling>){
        for (d in dwelling) {
            binding.rgDwelling.addView(RadioButton(context).apply {
                id = d.id
                text = context.getString(R.string.radio_group_items, d.name)
                textSize = 20F
                isChecked = true
                setTextColor(getColor(context, R.color.primary))
                buttonTintList = ColorStateList.valueOf(getColor(context, R.color.primary))
            })
        }
    }

    private fun initSpells() {
        var typeId: Int
        val spellList = mutableListOf<Spell>()
        viewModel.getRole(args.id)
        viewModel.getStartSpellTypes(args.id)

        typeAdapter = TypeAdapter(onItemSelected = {
            typeId = it.typeId
            viewModel.getSpellsByType(typeId)
            typeAdapter.updateTypes(viewModel.spellType.value!!)
        })
        binding.rvTypes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTypes.adapter = typeAdapter

        spellAdapter = SpellAdapter( onItemSelected = {
            addSelectedSpells(it, spellList)
        })
        binding.rvSpells.layoutManager = GridLayoutManager(context, 4)
        binding.rvSpells.adapter = spellAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.role.observe(viewLifecycleOwner) {
                    numSpells = it.spells
                    if (it.spells != 0){
                        binding.selectedSpells.text = getString(R.string.selected_spells, 0, numSpells)
                    }
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spellType.observe(viewLifecycleOwner) {
                    typeAdapter.updateTypes(it)
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.spell.observe(viewLifecycleOwner) {
                    spellAdapter.updateSpells(it)
                }
            }
        }

    }

    private fun initVictoryPoints(){
        viewModel.getVictoryPoints()
        binding.headVictoryPoints.text = getString(R.string.victory_points, 0)
        vpAdapter = VictoryPointsAdapter(onItemSelected = {
            binding.headVictoryPoints.text = getString(R.string.victory_points, it)
            println(it)
        })
        binding.rvVictoryPoints.layoutManager = LinearLayoutManager(context)
        binding.rvVictoryPoints.adapter = vpAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.vp.observe(viewLifecycleOwner) {
                    vpAdapter.updateVictoryPoints(it)
                }
            }
        }

    }

    private fun addSelectedSpells(it: Spell, spellList: MutableList<Spell>){

        var maxSpells = spellList.count()

        if (maxSpells < numSpells && !spellList.contains(it)){
            spellList.add(it)
            maxSpells = spellList.count() // Count again to refresh text
            binding.selectedSpells.text = getString(R.string.selected_spells, maxSpells, numSpells)
            if (maxSpells == numSpells){
                binding.rvTypes.visibility = View.GONE
                binding.rvSpells.visibility = View.GONE
            }
            //Add Views to selected spells layout
            val view = TextView(context)
            view.text = spellList.last().name
            view.textSize = 20F
            binding.lySpellLayout.addView(view)
            binding.lySpellLayout.setOnClickListener {
                binding.lySpellLayout.removeAllViews()
                spellList.clear()
                binding.rvTypes.visibility = View.VISIBLE
                binding.rvSpells.visibility = View.VISIBLE
                binding.selectedSpells.text = getString(R.string.selected_spells, 0, numSpells)
            }
        } else {
            Toast.makeText(context, getString(R.string.toast_already_spell, it.name), Toast.LENGTH_SHORT).show()
        }
    }

}