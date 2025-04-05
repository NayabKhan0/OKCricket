package com.android.okcricket.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.okcricket.R
import com.android.okcricket.databinding.FragmentMatchDetailsBinding
import com.android.okcricket.databinding.FragmentTeamDetailsBinding
import com.android.okcricket.network.ResultState
import com.android.okcricket.viewmodel.MatchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MatchDetailsFragment : Fragment() {

    private val viewModel: MatchViewModel by viewModel()
    private lateinit var binding: FragmentMatchDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)

        viewModel.getFirstMatch()

        viewModel.firstMatchData.observe(requireActivity()) { it ->
            when (it) {
                is ResultState.Loading -> {
                    Log.e("", "")
                }

                is ResultState.Success -> {
                    Log.e("", "")
                }

                is ResultState.Error -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.playerInfoCardView.setOnClickListener {
            findNavController().navigate(R.id.action_matchDetailsFragment_to_teamDetailsFragment)
        }

        return binding.root
    }

}