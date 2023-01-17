package com.example.scorelivepoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scorelivepoc.databinding.FragmentInitBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class InitFragment : Fragment() {

    private lateinit var binding: FragmentInitBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInitBinding.inflate(inflater, container, false)

        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.ingresarButton.setOnClickListener {
            findNavController().navigate(R.id.initFragment_to_scoreFragment)
        }
    }
}