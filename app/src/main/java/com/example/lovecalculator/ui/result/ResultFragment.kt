package com.example.lovecalculator.ui.result

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.ui.calculate.CalculateFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultFragment : Fragment() {
    lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
        getResult()

    }

    private fun initClickers() {
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigate(R.id.calculateFragment)
        }
        binding.btnHistory.setOnClickListener{
            findNavController().navigate(R.id.historyFragment)
        }

    }

    private fun getResult() {
        if (arguments != null) {
            val result = arguments?.getSerializable(CalculateFragment.LOVE_MODEL) as LoveModel
            binding.tvFirstName.text = result.firstName
            binding.tvSecondName.text = result.secondName
            binding.tvResult.text = result.percentage

        }

    }

}