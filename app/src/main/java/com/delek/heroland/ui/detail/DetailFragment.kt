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
import androidx.navigation.fragment.findNavController
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
        initUI()
        return binding.root
    }

    private fun initUI() {
        initListeners()
        initHeader()
        initAdvantages()
        initChits()
        initDwellings()
        initWeapon()
        initArmor()
        initSpells()
        initNatives()
    }

    private fun initListeners() {
        binding.ivCancel.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionNavDetailToNavRoleSelect()
            )
        }
        binding.ivCheck.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionNavDetailToOptionsFragment()
            )
        }
    }

    private fun initHeader() {
        viewModel.getRoles(args.id)
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
        viewModel.getAdvantages(args.id)
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

        viewModel.getChitsByRole(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.chit.observe(viewLifecycleOwner) {
                    chitAdapter.updateList(it)
                }
            }
        }
    }

    private fun initDwellings() {
        viewModel.getDwellingsByRole(args.id)
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
        viewModel.getWeapons(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.weapon.observe(viewLifecycleOwner) {
                    binding.tvWeapon.text = it[0].name
                }
            }
        }
    }

    private fun initArmor() {
        viewModel.getAmor(args.id)
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
        viewModel.getSpells(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                val count = viewModel.countStartSpells(args.id)
                viewModel.startSpell.observe(viewLifecycleOwner){
                    var spells = ""
                    val numSpells = countToString(count)
                    val list: MutableList<String> = mutableListOf()
                    for (i in it) { list.add(i.spellType) }
                    if (list.isNotEmpty()) {
                        spells = list.joinToString(
                            prefix = "$numSpells (type ",
                            postfix = ")",
                            separator = ", "
                        )
                    } else {
                        binding.tvSpells.visibility = View.GONE
                    }
                    binding.tvSpells.text = spells
                }
            }
        }
    }

    private fun initNatives() {
        viewModel.getAllyNatives(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.allyNatives.observe(viewLifecycleOwner) {
                    val ally: MutableList<String> = mutableListOf()
                    for (i in it) {
                        ally.add(i.name)
                    }
                    if (ally.isEmpty()) binding.tvAlly.visibility = View.GONE
                    binding.tvAlly.text = ally.joinToString(prefix = "ALLY: ", separator = ", ")
                }
            }
        }
        viewModel.getFriendlyNatives(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.friendlyNatives.observe(viewLifecycleOwner) {
                    println(it)
                    val friend: MutableList<String> = mutableListOf()
                    for (i in it) {
                        friend.add(i.name)
                    }
                    if (friend.isEmpty()) binding.tvFriendly.visibility = View.GONE
                    binding.tvFriendly.text =
                        friend.joinToString(prefix = "FRIENDLY: ", separator = ", ")
                }
            }
        }
        viewModel.getUnfriendlyNatives(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.unfriendlyNatives.observe(viewLifecycleOwner) {
                    val unfriend: MutableList<String> = mutableListOf()
                    for (i in it) {
                        unfriend.add(i.name)
                    }
                    if (unfriend.isEmpty()) binding.tvUnfriendly.visibility = View.GONE
                    binding.tvUnfriendly.text =
                        unfriend.joinToString(prefix = "UNFRIENDLY: ", separator = ", ")
                }
            }
        }
        viewModel.getEnemyNatives(args.id)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.enemyNatives.observe(viewLifecycleOwner) {
                    val enemy: MutableList<String> = mutableListOf()
                    for (i in it) { enemy.add(i.name) }
                    if (enemy.isEmpty()) binding.tvEnemy.visibility = View.GONE
                    binding.tvEnemy.text = enemy.joinToString(prefix = "ENEMY: ", separator = ", ")
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