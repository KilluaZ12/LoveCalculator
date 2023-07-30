package com.example.lovecalculator.ui.calculate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.data.local.Pref
import com.example.lovecalculator.databinding.FragmentCalculateBinding
import com.example.lovecalculator.main.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding
    private val loveViewModel: LoveViewModel by viewModels()
    @Inject
    lateinit var pref: Pref


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!pref.isOnBoardSeen()) {
            findNavController().navigate(R.id.onBoardFragment)
        }

        initClickers()

    }

    private fun initClickers() {
        binding.btnCalculate.setOnClickListener {
            if (binding.etFirstName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty()) {
                loveViewModel.getLiveData(
                    binding.etFirstName.text.toString(),
                    binding.etSecondName.text.toString()
                ).observe(requireActivity()){
                    if (it.error != null) {
                        Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                    } else {
                        findNavController().navigate(
                            R.id.resultFragment,
                            bundleOf(LOVE_MODEL to it)
                        )
                    }
                }
            }
        }
    }

    companion object {
        const val LOVE_MODEL = "love_model"
    }
}