package com.delek.heroland.ui.roleselect

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.databinding.FragmentRoleSelectBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoleSelectFragment : Fragment() {

    private val viewModel: RoleSelectViewModel by viewModels()
    private var _binding: FragmentRoleSelectBinding? = null
    private val binding get() = _binding!!
    private lateinit var roleAdapter: RoleSelectAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRoleSelectBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        roleAdapter = RoleSelectAdapter(onItemSelected = {
            findNavController().navigate(
                RoleSelectFragmentDirections.actionNavRoleSelectToNavDetail(it.id)
            )
        })
        binding.rvRole.layoutManager = GridLayoutManager(context, 2)
        binding.rvRole.adapter = roleAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.roleEntity.observe(viewLifecycleOwner) {
                    roleAdapter.updateList(it)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}