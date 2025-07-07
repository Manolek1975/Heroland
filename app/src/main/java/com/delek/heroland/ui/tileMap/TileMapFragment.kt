package com.delek.heroland.ui.tileMap

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.delek.heroland.databinding.FragmentTileMapBinding

class TileMapFragment : Fragment() {

    private var _binding: FragmentTileMapBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTileMapBinding.inflate(inflater, container, false)
        val tileMap = DrawTileMap(requireContext())
        return tileMap
    }
}