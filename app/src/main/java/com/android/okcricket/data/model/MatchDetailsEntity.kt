package com.android.okcricket.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class MatchDetailsEntity(
    val team1FullName: String?,
    val team1ShortName: String?,
    val team2FullName: String?,
    val team2ShortName: String?,
    val weather: String?,
    val venue: String?,
    val tourName: String?,
    val combineTeamPlayer: CombineTeamPlayer,
)

@Parcelize
data class CombineTeamPlayer(
    val team1Player: List<PlayerDetailsEntity>? = emptyList(),
    val team2Player: List<PlayerDetailsEntity>? = emptyList()
) : Parcelable

@Parcelize
data class PlayerDetailsEntity(
    val name: String?,
    val position: String?,
    val isCaptain: Boolean?,
    val isKeeper: Boolean?,
    val battingStyle: String?,
    val bowlingStyle: String?
) : Parcelable