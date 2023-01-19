package com.example.scorelivepoc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scorelivepoc.databinding.FragmentRecommendationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendationsFragment : Fragment() {

    private lateinit var binding: FragmentRecommendationsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendationsBinding.inflate(inflater, container, false)


        fillList()
        setListeners()

        return binding.root
    }

    private fun fillList() {
        val arrayAdapter: ArrayAdapter<*>
        val users = arrayOf(
            "1 - Paga tu cuota por adelantado ",
            "2 - Paga tu cuota por adelantado ",
            "3 - Paga tu cuota por adelantado ",
        )

        // access the listView from xml file
        val mListView = binding.recommendationsListView
        arrayAdapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, users
        )
        mListView.adapter = arrayAdapter
    }

    private fun setListeners() {
        binding.toolbarLayout.backToolbar.setOnClickListener {
            findNavController().popBackStack()
        }
    }


}