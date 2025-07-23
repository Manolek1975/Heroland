package com.delek.heroland.ui.nativeDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.delek.heroland.R
import com.delek.heroland.databinding.FragmentNativeDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.Field

@AndroidEntryPoint
class NativeDetailFragment : Fragment() {

    companion object {
        fun newInstance() = NativeDetailFragment()
    }

    private val viewModel: NativeDetailViewModel by viewModels()
    private var _binding: FragmentNativeDetailBinding? = null
    private val binding get() = _binding!!
    private val args: NativeDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNativeDetailBinding.inflate(inflater, container, false)

        viewModel.getNativeById(args.nativeId)
        viewModel.native.observe(viewLifecycleOwner) { native ->
            binding.tvTypeNative.text = native.type
            val id = getResId(native.image, R.drawable::class.java)
            binding.ivNative.ivNative.setImageResource(id)
            binding.ivNativeAlerted.ivNative.setImageResource(id)
            binding.ivNative.nameNative.text = native.name
            binding.ivNativeAlerted.nameNative.text = native.name
            binding.ivNative.fightA.text = native.fightA
            native.moveA.toString().also { binding.ivNative.moveA.text = it }
            binding.ivNativeAlerted.fightA.text = native.fightB
            native.moveB.toString().also { binding.ivNativeAlerted.moveA.text = it }
            //binding.ivNativeAlerted.setImageResource(native.image)
        }

        binding.arrowBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        return binding.root
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