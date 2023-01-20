package com.example.scorelivepoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scorelivepoc.databinding.FragmentBienvenidaBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BienvenidaFragment : Fragment() {

    private lateinit var binding: FragmentBienvenidaBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBienvenidaBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.toolbarLayout.backToolbar.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.salirButton.setOnClickListener {
            requireActivity().finishAffinity()
        }
    }
}