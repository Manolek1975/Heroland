package com.delek.heroland.ui.dwelling

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
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.delek.heroland.databinding.FragmentDwellingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DwellingFragment : Fragment() {

    companion object {
        fun newInstance() = DwellingFragment()
    }

    private val viewModel: DwellingViewModel by viewModels()
    private var _binding: FragmentDwellingBinding? = null
    private val binding get() = _binding!!
    private val args: DwellingFragmentArgs by navArgs()
    private lateinit var nativeAdapter: NativeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDwellingBinding.inflate(inflater, container, false)
        initUI()
        return binding.root
    }

    private fun initUI() {
        viewModel.getDwellingById(args.id)
        viewModel.dwelling.observe(viewLifecycleOwner) { dwelling ->
            binding.dwellingName.text = dwelling.name
        }
        viewModel.getGroupByStart(args.id)
        viewModel.group.observe(viewLifecycleOwner) { group ->
            binding.groupName.text = group.name
            //adapter = NativeAdapter()
            nativeAdapter = NativeAdapter(onItemSelected = {
                findNavController().navigate(
                    DwellingFragmentDirections.actionNavDwellingToNavNativeDetail(it.id)
                )
            })
            binding.rvNative.layoutManager = GridLayoutManager(context, 4)
            binding.rvNative.adapter = nativeAdapter
            viewModel.getNativeByGroup(group.id)
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.natives.observe(viewLifecycleOwner) {
                        nativeAdapter.updateList(it)
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}