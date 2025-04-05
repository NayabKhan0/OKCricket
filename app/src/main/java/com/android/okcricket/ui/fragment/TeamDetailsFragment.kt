package com.android.okcricket.ui.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.okcricket.R
import com.android.okcricket.data.model.PlayerDetailsEntity
import com.android.okcricket.databinding.FragmentTeamDetailsBinding
import com.android.okcricket.ui.adapter.PlayerInfoAdapter
import com.google.android.material.chip.Chip


class TeamDetailsFragment : Fragment() {

    private lateinit var binding: FragmentTeamDetailsBinding
    private var playerList: List<PlayerDetailsEntity> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamDetailsBinding.inflate(inflater, container, false)

        val combineTeamPlayer =
            TeamDetailsFragmentArgs.fromBundle(requireArguments()).playerList
        playerList = combineTeamPlayer.team1Player!! + combineTeamPlayer.team2Player!!

        val adapter = PlayerInfoAdapter(playerList) {
            showPlayerDialog(it)
        }
        binding.playerListRecyclerView.adapter = adapter
        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedId ->
            val chip = group.findViewById<Chip>(checkedId[0])
            when (chip.id) {
                R.id.allChip -> {
                    playerList = combineTeamPlayer.team1Player + combineTeamPlayer.team2Player
                    adapter.updateList(playerList)
                }

                R.id.teamAChip -> {
                    adapter.updateList(combineTeamPlayer.team1Player)
                }

                R.id.teamBChip -> {
                    adapter.updateList(combineTeamPlayer.team2Player)
                }
            }

        }

        binding.arrowIcon.setOnClickListener {
            findNavController().navigateUp()
        }

        return binding.root
    }

    private fun showPlayerDialog(playerDetailsEntity: PlayerDetailsEntity) {

        AlertDialog.Builder(requireContext())
            .setTitle("Player Info")
            .setMessage(
                "Name: ${playerDetailsEntity.name}\nBatting Style: ${playerDetailsEntity.battingStyle}\n" +
                        "Bowling Style: ${playerDetailsEntity.bowlingStyle}"
            )
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}