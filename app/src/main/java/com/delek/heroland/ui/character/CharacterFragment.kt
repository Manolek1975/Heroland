package com.delek.heroland.ui.character

import android.content.Context
import android.content.SharedPreferences
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
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.R
import com.delek.heroland.core.Game
import com.delek.heroland.databinding.FragmentCharacterBinding
import com.delek.heroland.ui.detail.ChitAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private val viewmodel: CharacterViewModel by viewModels()
    private var _binding: FragmentCharacterBinding? = null
    private val binding get() = _binding!!
    private lateinit var data: SharedPreferences
    private lateinit var chitAdapter: ChitAdapter
    var roleId = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        roleId = data.getInt("role_id", 0)
        initHeader()
        initAdvantages()
        initChits()
/*        viewmodel.geRoleById(args.id)
        viewmodel.role.observe(viewLifecycleOwner) { role ->
            binding.characterName.text = role.name
        }*/
    }

    private fun initHeader() {
        viewmodel.geRoleById(roleId)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.role.observe(viewLifecycleOwner) {
                    binding.characterName.text = it.name
                    binding.characterSymbol.text = it.symbol
                    binding.characterWeight.text = getString(R.string.weight_vulnerability, it.weight)
                    val id = Game().getResId(it.icon, R.drawable::class.java)
                    binding.ivIcon.setImageResource(id)
                }
            }
        }
    }

    private fun initAdvantages() {
        var x = 0
        viewmodel.getAdvantages(roleId)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.advantages.observe(viewLifecycleOwner) {
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

        viewmodel.getChitsByRole(roleId)
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewmodel.chit.observe(viewLifecycleOwner) {
                    chitAdapter.updateList(it)
                }
            }
        }
    }

    private fun dialogDescription(name: String, description: String) {
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AppTheme_AlertDialogStyle)
        //dialogBuilder.setIcon(android.R.drawable.ic_menu_info_details)
        dialogBuilder.setTitle(name)
        dialogBuilder.setMessage(description)
        dialogBuilder.setPositiveButton("OK"){_, _: Int ->}.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}