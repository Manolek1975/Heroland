package com.delek.heroland.ui.player

import android.annotation.SuppressLint
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
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentPlayerBinding
import com.delek.heroland.domain.model.Role
import com.delek.heroland.ui.player.PlayerAdapter.Companion.rolePos
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PlayerFragment : Fragment() {
    private var _binding: FragmentPlayerBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PlayerViewModel by viewModels()
    private lateinit var playerAdapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initUI() {
        initListeners()
        initPlayers()
    }

    private fun initListeners(){
        binding.fabGo.setOnClickListener {
            findNavController().navigate(
                PlayerFragmentDirections.actionNavPlayerToMapFragment()
            )
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(
                PlayerFragmentDirections.actionNavPlayerToNavRoleSelect()
            )
        }
    }

    private fun initPlayers(){
        checkPlayers()
        viewModel.getRolesByPlayer()
        playerAdapter = PlayerAdapter(onItemSelected = {
            dialogDelete(it, rolePos)
        })
        binding.rvPlayer.layoutManager = LinearLayoutManager(context)
        binding.rvPlayer.adapter = playerAdapter

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.roles.observe(viewLifecycleOwner) {
                    playerAdapter.updateList(it)
                }
            }
        }
    }

    private fun dialogDelete(it: Role, pos: Int) {
        val dialogBuilder = AlertDialog.Builder(requireContext(), R.style.AppTheme_AlertDialogStyle)
        dialogBuilder.setIcon(android.R.drawable.ic_dialog_alert)
        dialogBuilder.setTitle(it.name)
        dialogBuilder.setMessage(getString(R.string.delete_player, it.name))
        dialogBuilder.setNegativeButton("Cancel"){_, _: Int ->}
        dialogBuilder.setPositiveButton("OK"){_, _: Int ->
            viewModel.deletePlayer(it.id)
            playerAdapter.notifyItemRemoved(pos)
            viewModel.getRolesByPlayer()
            playerAdapter.updateList(viewModel.roles.value!!)
            checkPlayers()
        }.show()
    }

    private fun checkPlayers() {
        lifecycleScope.launch {
            viewModel.roles.observe(viewLifecycleOwner) {
                if (it.size == 16) {
                    binding.fabAdd.visibility = View.GONE
                } else {
                    binding.fabAdd.visibility = View.VISIBLE
                }
            }
        }
    }

}