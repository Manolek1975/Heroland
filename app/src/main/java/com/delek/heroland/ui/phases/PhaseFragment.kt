package com.delek.heroland.ui.phases

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.delek.heroland.databinding.FragmentPhaseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PhaseFragment : Fragment() {

    companion object {
        fun newInstance() = PhaseFragment()
    }

    private val viewModel: PhaseViewModel by viewModels()
    private var _binding: FragmentPhaseBinding? = null
    private val binding get() = _binding!!
    private lateinit var data: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        data = requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        initUI()
    }

    private fun initUI() {
        dayPhases()

    }

    fun dayPhases() {
        val day = data.getInt("day", 0)
        viewModel.getPhasesByDay(day)
        val dayPhaseAdapter = DayPhaseAdapter(onItemSelected = {
            //TODO make phases
        })
        binding.rvDayPhases.layoutManager = LinearLayoutManager(context)
        binding.rvDayPhases.adapter = dayPhaseAdapter
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.dayPhases.observe(viewLifecycleOwner) {
                    dayPhaseAdapter.updateList(it)
                }
            }
        }
    }

}