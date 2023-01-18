package com.example.scorelivepoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scorelivepoc.databinding.FragmentHistoricoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoricoFragment: Fragment() {

    private lateinit var binding: FragmentHistoricoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoricoBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.toolbarLayout.backToolbar.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}