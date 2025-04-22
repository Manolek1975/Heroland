package com.delek.heroland.ui.options

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
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
        viewModel.getRole(args.id)
        viewModel.getStartSpellTypes(args.id)
        //viewModel.getSpellsByType(2)
        var typeId = 0
        typeAdapter = TypeAdapter(onItemSelected = {
            println(it.id)
            typeId = it.id
            viewModel.getSpellsByType(typeId)
        })

        binding.rvTypes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvTypes.adapter = typeAdapter

        spellAdapter = SpellAdapter()
        binding.rvSpells.layoutManager = GridLayoutManager(context, 4)
        binding.rvSpells.adapter = spellAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.role.observe(viewLifecycleOwner) {
                    if (it.spells != 0)
                    binding.headSpells.text = getString(R.string.head_spells, it.spells.toString())
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getRole(args.id)
                viewModel.spellType.observe(viewLifecycleOwner) {
                    typeAdapter.updateTypes(it)
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getRole(args.id)
                viewModel.spell.observe(viewLifecycleOwner) {
                    spellAdapter.updateSpells(it)
                }
            }
        }
    }

}