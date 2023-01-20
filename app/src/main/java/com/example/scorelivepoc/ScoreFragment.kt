package com.example.scorelivepoc

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.scorelivepoc.databinding.FragmentScoreBinding
import com.example.scorelivepoc.model.Percentage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var percentage: Percentage

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreBinding.inflate(inflater, container, false)

        percentage = Percentage(80)
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.toolbarLayout.backToolbar.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.recomendacionesButton.setOnClickListener {
            findNavController().navigate(R.id.scoreFragment_to_recommendationsFragment)
        }

        binding.verHistoricoButton.setOnClickListener {
            findNavController().navigate(R.id.scoreFragment_to_historicoFragment)
        }

        setProgress()
        setTextFromProgressValue()

    }

    private fun setProgress() {
        val progressDrawable = ResourcesCompat.getDrawable(
            resources,
            percentage.drawableProgress,
            requireActivity().theme
        )

        binding.scoreProgressBar.apply {
            secondaryProgress = percentage.value
            setProgressDrawable(progressDrawable)
        }

    }

    private fun setTextFromProgressValue() {
        val color = resources.getColor(percentage.color, requireActivity().theme)
        val percentageStringValue = "${percentage.value} / 100"
        val endLength = percentageStringValue.split(" /")[0].length

        val spannableText = SpannableString(percentageStringValue)
        spannableText.setSpan(
            ForegroundColorSpan(color), 0, endLength, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        binding.percentageProgressTextView.text = spannableText

        binding.statusScoreTextView.apply {
            setTextColor(color)
            text = percentage.statusText
        }
    }
}