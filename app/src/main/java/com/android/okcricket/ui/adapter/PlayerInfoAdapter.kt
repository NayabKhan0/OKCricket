package com.android.okcricket.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.okcricket.data.model.PlayerDetailsEntity
import com.android.okcricket.databinding.PlayerItemBinding

class PlayerInfoAdapter(private var players: List<PlayerDetailsEntity>) :
    RecyclerView.Adapter<PlayerInfoAdapter.PlayerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerInfoAdapter.PlayerViewHolder {
        val binding = PlayerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlayerViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: PlayerInfoAdapter.PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.binding.apply {
            if (player.isCaptain == true && player.isKeeper == true) {
                playerNameTextView.text = "${player.name}(C)/(WK)"
            } else if (player.isCaptain == true) {
                playerNameTextView.text = "${player.name}(C)"
            } else if (player.isKeeper == true) {
                playerNameTextView.text = "${player.name}(WK)"
            } else {
                playerNameTextView.text = player.name
            }
            playerPositionTextView.text = player.position
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newList: List<PlayerDetailsEntity>) {
        players = newList
        notifyDataSetChanged()
    }

    override fun getItemCount() = players.size

    inner class PlayerViewHolder(val binding: PlayerItemBinding) :
        RecyclerView.ViewHolder(binding.root)

}