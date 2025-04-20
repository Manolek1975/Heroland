package com.delek.heroland.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.lang.reflect.Field

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var _binding: FragmentDetailBinding
    private val binding get() = _binding
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by viewModels()
    private lateinit var chitAdapter: ChitAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel.getRoles(args.id)
        viewModel.getAdvantages(args.id)
        viewModel.getChitsByRole(args.id)
        viewModel.getDwellingsByRole(args.id)
        viewModel.getWeapons(args.id)
        viewModel.getAmor(args.id)
        viewModel.getSpells(args.id)
        initUI()
        return binding.root
    }

    private fun initUI() {
        initHeader()
        initAdvantages()
        initChits()
        initDwellings()
        initWeapon()
        initArmor()
        initSpells()
    }

    private fun initHeader() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.role.observe(viewLifecycleOwner) {
                    binding.tvName.text = it.name
                    binding.tvSymbol.text = it.symbol
                    binding.tvWeight.text = getString(R.string.weight_vulnerability, it.weight)
                    val id = getResId(it.icon, R.drawable::class.java)
                    binding.ivIcon.setImageResource(id)
                }
            }
        }
    }

    private fun initAdvantages() {
        var x = 0
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.advantages.observe(viewLifecycleOwner) {
                    ++x
                    if (x == 1) {
                        val name = it.name
                        val description = it.description
                        binding.tvAdv1.text = getString(R.string.advantage_1, name)
                        binding.tvAdv1.setOnClickListener{dialogDescription(name, description)}
                    }
                    if (x == 2) {
                        val name = it.name
                        val description = it.description
                        binding.tvAdv2.text = getString(R.string.advantage_2, name)
                        binding.tvAdv2.setOnClickListener {dialogDescription(name, description)}
                    }
                }
            }
        }
    }

    private fun initChits() {
        chitAdapter = ChitAdapter()
        binding.rvChits.layoutManager = GridLayoutManager(context, 3)
        binding.rvChits.adapter = chitAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.chit.observe(viewLifecycleOwner) {
                    chitAdapter.updateList(it)
                }
            }
        }
    }

    private fun initDwellings() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dwelling.observe(viewLifecycleOwner) {
                    val list: MutableList<String> = mutableListOf()
                    for (i in it) { list.add(i.name) }
                    val start = list.joinToString(
                        prefix = "Start at ",
                        postfix = " with 10 GOLD",
                        separator = ", ",
                    )
                    binding.tvStart.text = start
                }
            }
        }
    }

    private fun initWeapon() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.weapon.observe(viewLifecycleOwner) {
                    binding.tvWeapon.text = it[0].name
                }
            }
        }
    }

    private fun initArmor() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.armor.observe(viewLifecycleOwner) {
                    var armor = ""
                    val list: MutableList<String> = mutableListOf()
                    for (i in it) { list.add(i.name) }
                    if (list.isNotEmpty())
                        armor = list.joinToString(prefix = ", ", separator = ", ")
                    binding.tvArmor.text = armor
                }
            }
        }
    }

    private fun initSpells() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                val count = viewModel.countStartSpells(args.id)
                viewModel.startSpell.observe(viewLifecycleOwner){
                    val numSpells = countToString(count)
                    var spell = ""
                    val list: MutableList<String> = mutableListOf()
                    for (i in it) { list.add(i.spellType) }
                    if (list.isNotEmpty())
                        spell = list.joinToString(prefix = "$numSpells (type ",
                            postfix = ")",
                            separator = ", ")
                    binding.tvSpells.text = spell
                }
            }

        }

    }

    private fun countToString(count: Int): String {
        var numSpells = ""
        when (count) {
            1 -> numSpells ="One spell"
            2 -> numSpells ="Two spells"
            3 -> numSpells ="Three spells"
            4 -> numSpells ="Four spells"
        }
        return numSpells
    }

    private fun dialogDescription(name: String, description: String) {
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AppTheme_AlertDialogStyle)
        //dialogBuilder.setIcon(android.R.drawable.ic_menu_info_details)
        dialogBuilder.setTitle(name)
        dialogBuilder.setMessage(description)
        dialogBuilder.setPositiveButton("OK"){_, _: Int ->}.show()
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