package com.android.okcricket.mapper

import com.android.okcricket.data.model.CombineTeamPlayer
import com.android.okcricket.data.model.MatchDetailsEntity
import com.android.okcricket.data.model.MatchResponse
import com.android.okcricket.data.model.PlayerDetailsEntity

object MatchDetailsMapper {

    var teamHome = ""
    var teamAway = ""

    fun getMatchDetails(response: MatchResponse): MatchDetailsEntity {
        teamHome = response.matchDetail.teamHome
        teamAway = response.matchDetail.teamAway

        val team1Player = response.teams[teamHome]?.players?.map { (key, player) ->
            PlayerDetailsEntity(
                name = player.name_full,
                position = player.position,
                isCaptain = player.is_captain,
                isKeeper = player.is_keeper,
                battingStyle = player.batting.style,
                bowlingStyle = player.bowling.style
            )
        }

        val team2Player = response.teams[teamAway]?.players?.map { (key, player) ->
            PlayerDetailsEntity(
                name = player.name_full,
                position = player.position,
                isCaptain = player.is_captain,
                isKeeper = player.is_keeper,
                battingStyle = player.batting.style,
                bowlingStyle = player.bowling.style
            )
        }


        return MatchDetailsEntity(
            team1FullName = response.teams[teamHome]?.name_full ?: "",
            team1ShortName = response.teams[teamHome]?.name_short ?: "",
            team2FullName = response.teams[teamAway]?.name_full ?: "",
            team2ShortName = response.teams[teamAway]?.name_short ?: "",
            weather = response.matchDetail.weather,
            venue = response.matchDetail.venue.name,
            tourName = response.matchDetail.series.tourName,
            combineTeamPlayer = CombineTeamPlayer(
                team1Player = team1Player,
                team2Player = team2Player
            )
        )
    }
}