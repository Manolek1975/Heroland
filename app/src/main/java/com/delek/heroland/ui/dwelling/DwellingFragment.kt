package com.delek.heroland.ui.dwelling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.heroland.databinding.FragmentDwellingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DwellingFragment : Fragment() {

    companion object {
        fun newInstance() = DwellingFragment()
    }

    private val viewmodel: DwellingViewModel by viewModels()
    private var _binding: FragmentDwellingBinding? = null
    private val binding get() = _binding!!
    private val args: DwellingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDwellingBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewmodel.getGroupByStart(args.id)
        viewmodel.group.observe(viewLifecycleOwner) { group ->
            binding.groupName.text = group.name
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewmodel.getDwellingById(args.id)
        viewmodel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            binding.dwellingName.text = dwelling.name
        }
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}