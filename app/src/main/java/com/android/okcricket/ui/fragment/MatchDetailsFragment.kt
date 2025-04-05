package com.android.okcricket.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.android.okcricket.R
import com.android.okcricket.data.model.CombineTeamPlayer
import com.android.okcricket.data.model.MatchDetailsEntity
import com.android.okcricket.data.model.PlayerDetailsEntity
import com.android.okcricket.databinding.FragmentMatchDetailsBinding
import com.android.okcricket.network.ResultState
import com.android.okcricket.viewmodel.MatchViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MatchDetailsFragment : Fragment() {

    private val viewModel: MatchViewModel by viewModel()
    private lateinit var binding: FragmentMatchDetailsBinding
    private lateinit var combineTeamPlayer: CombineTeamPlayer
    private var isFirstMatch = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchDetailsBinding.inflate(inflater, container, false)

        viewModel.getFirstMatch()

        viewModel.firstMatchData.observe(requireActivity()) { it ->
            when (it) {
                is ResultState.Loading -> {
                    showLoading()
                }

                is ResultState.Success -> {
                    dismissLoading()
                    handleResponse(it.data)
                }

                is ResultState.Error -> {
                    dismissLoading()
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        viewModel.secondMatchData.observe(requireActivity()) { it ->
            when (it) {
                is ResultState.Loading -> {
                    showLoading()
                }

                is ResultState.Success -> {
                    dismissLoading()
                    handleResponse(it.data)
                }

                is ResultState.Error -> {
                    dismissLoading()
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_LONG).show()
                }
            }
        }

        binding.playerInfoCardView.setOnClickListener {
            val action = MatchDetailsFragmentDirections
                .actionMatchDetailsFragmentToTeamDetailsFragment(combineTeamPlayer)
            findNavController().navigate(action)
        }

        binding.anotherDataCardView.setOnClickListener {
            if (isFirstMatch) {
                viewModel.getFirstMatch()
            } else {
                viewModel.getSecondMatch()
            }
            isFirstMatch = !isFirstMatch // Toggle it for next click
        }

        return binding.root
    }

    private fun handleResponse(data: MatchDetailsEntity) {
        binding.tourName.text = data.tourName
        binding.venueTextView.text = data.venue
        binding.weatherTextView.text = data.weather

        if (data.team1ShortName.equals("SA") && data.team2ShortName.equals("PAK") ||
            data.team1ShortName.equals("PAK") && data.team2ShortName.equals("SA")) {
            binding.team1CircleImageView.setImageResource(R.drawable.south_africa_flag)
            binding.team2CircleImageView.setImageResource(R.drawable.pakistan_flag)
            binding.team1ShortName.text = data.team1ShortName
            binding.team2ShortName.text = data.team2ShortName
        } else if (data.team1ShortName.equals("NZ") && data.team2ShortName.equals("IND") ||
            data.team1ShortName.equals("IND") && data.team2ShortName.equals("NZ")) {
            binding.team1CircleImageView.setImageResource(R.drawable.new_zealand_flag)
            binding.team2CircleImageView.setImageResource(R.drawable.india_flag)
            binding.team1ShortName.text = data.team1ShortName
            binding.team2ShortName.text = data.team2ShortName
        }
        combineTeamPlayer = data.combineTeamPlayer
    }


    private fun showLoading() {
        binding.mainCardView.visibility = View.GONE
        binding.anotherDataCardView.visibility = View.GONE
        binding.playerInfoCardView.visibility = View.GONE
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun dismissLoading() {
        binding.mainCardView.visibility = View.VISIBLE
        binding.anotherDataCardView.visibility = View.VISIBLE
        binding.playerInfoCardView.visibility = View.VISIBLE
        binding.progressBar.visibility = View.GONE
    }
}