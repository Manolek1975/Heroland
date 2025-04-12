package com.delek.heroland.ui.roleselect

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.databinding.FragmentRolSelectBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoleSelectFragment : Fragment() {

    private val viewModel: RoleSelectViewModel by viewModels()
    private var _binding: FragmentRolSelectBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: RoleSelectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRolSelectBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        adapter = RoleSelectAdapter(onItemSelected = {
            Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()} )
        binding.rvRole.layoutManager = GridLayoutManager(context, 2)
        binding.rvRole.adapter = adapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.roleEntity.observe(viewLifecycleOwner) {
                    adapter.updateList(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}