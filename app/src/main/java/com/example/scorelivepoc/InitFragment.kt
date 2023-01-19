package com.example.scorelivepoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
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

        binding.usuarioEditText.doOnTextChanged { _, _, _, _ ->
            enableButton()
        }

        binding.contraseAEditText.doOnTextChanged { _, _, _, _ ->
            enableButton()
        }
    }

    private fun enableButton() {
        val usuario = binding.usuarioEditText.text.toString()
        val contrasenia = binding.contraseAEditText.text.toString()

        binding.ingresarButton.isEnabled = usuario.isNotBlank() && contrasenia.isNotBlank()
    }
}