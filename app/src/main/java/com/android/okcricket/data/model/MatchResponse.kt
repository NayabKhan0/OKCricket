package com.android.okcricket.data.model

import com.google.gson.annotations.SerializedName

data class MatchResponse(
    @SerializedName("Matchdetail")
    val matchDetail: MatchDetail,
    @SerializedName("Nuggets")
    val nuggets: ArrayList<String>,
    @SerializedName("Innings")
    val innings: ArrayList<Innings>,
    @SerializedName("Teams")
    val teams: Map<String, Team>,
    @SerializedName("Notes")
    val notes: Map<String, ArrayList<String>>
)

data class MatchDetail(
    @SerializedName("Team_Home")
    val teamHome: String,
    @SerializedName("Team_Away")
    val teamAway: String,
    @SerializedName("Match")
    val match: Match,
    @SerializedName("Series")
    val series: Series,
    @SerializedName("Venue")
    val venue: Venue,
    @SerializedName("Officials")
    val officials: Officials,
    @SerializedName("Weather")
    val weather: String,
    @SerializedName("Tosswonby")
    val tossWonBy: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Status_Id")
    val statusId: String,
    @SerializedName("Player_Match")
    val playerMatch: String,
    @SerializedName("Result")
    val result: String,
    @SerializedName("Winningteam")
    val winningTeam: String,
    @SerializedName("Winmargin")
    val winMargin: String,
    @SerializedName("Equation")
    val equation: String
)

data class Match(
    @SerializedName("Livecoverage")
    val liveCoverage: String,
    @SerializedName("Id")
    val id: String,
    @SerializedName("Code")
    val code: String,
    @SerializedName("League")
    val league: String,
    @SerializedName("Number")
    val number: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Date")
    val date: String,
    @SerializedName("Time")
    val time: String,
    @SerializedName("Offset")
    val offset: String,
    @SerializedName("Daynight")
    val dayNight: String
)

data class Series(
    @SerializedName("Id")
    val id: String,
    @SerializedName("Name")
    val name: String,
    @SerializedName("Status")
    val status: String,
    @SerializedName("Tour")
    val tour: String,
    @SerializedName("Tour_Name")
    val tourName: String
)

data class Venue(
    @SerializedName("Id")
    val id: String,
    @SerializedName("Name")
    val name: String
)

data class Officials(
    @SerializedName("Umpires")
    val umpires: String,
    @SerializedName("Referee")
    val referee: String
)

data class Team(
    @SerializedName("Name_Full")
    val name_full: String,
    @SerializedName("Name_Short")
    val name_short: String,
    @SerializedName("Players")
    val players: Map<String, Player>,
)

data class Innings(
    @SerializedName("Number")
    val number: String,
    @SerializedName("Battingteam")
    val battingTeam: String,
    @SerializedName("Total")
    val total: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Runrate")
    val runrate: String,
    @SerializedName("Byes")
    val byes: String,
    @SerializedName("Legbyes")
    val leabyes: String,
    @SerializedName("Wides")
    val wides: String,
    @SerializedName("Noballs")
    val no_balls: String,
    @SerializedName("Penalty")
    val penalty: String,
    @SerializedName("AllottedOvers")
    val allotted_overs: String,
    @SerializedName("Batsmen")
    val batsmens: ArrayList<batsmen>,
    @SerializedName("Partnership_Current")
    val current_partnership: PartnerShip,
    @SerializedName("FallofWickets")
    val fallofWickets: ArrayList<FallofWickets>,
    @SerializedName("PowerPlay")
    val power_play: PowerPlay,
    @SerializedName("Bowlers")
    val bowlers: ArrayList<bowlers>,

    )

data class batsmen(
    @SerializedName("Batsman")
    val batsmen: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Fours")
    val fours: String,
    @SerializedName("Sixes")
    val Sixes: String,
    @SerializedName("Dots")
    val dots: String,
    @SerializedName("Strikerate")
    val strikeRate: String,
    @SerializedName("Dismissal")
    val dissmissal: String,
    @SerializedName("Howout")
    val howout: String,
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Fielder")
    val fielder: String,

    )

data class PartnerShip(
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Balls")
    val balls: String,
    @SerializedName("Batsmen")
    val batsmen: ArrayList<batsmen>
)

data class FallofWickets(
    @SerializedName("Batsman")
    val batsmen: String,
    @SerializedName("Score")
    val score: String,
    @SerializedName("Overs")
    val overs: String
)

data class PowerPlay(
    @SerializedName("PP1")
    val power_play_1: String,
    @SerializedName("PP2")
    val power_play_2: String
)

data class bowlers(
    @SerializedName("Bowler")
    val bowler: String,
    @SerializedName("Overs")
    val overs: String,
    @SerializedName("Maidens")
    val maidens: String,
    @SerializedName("Runs")
    val runs: String,
    @SerializedName("Wickets")
    val wickets: String,
    @SerializedName("Economyrate")
    val economy_rate: String,
    @SerializedName("Noballs")
    val no_balls: String,
    @SerializedName("Wides")
    val wides: String,
    @SerializedName("Dots")
    val dots: String
)


data class Player(
    @SerializedName("Position")
    val position: String,
    @SerializedName("Name_Full")
    val name_full: String,
    @SerializedName("Iscaptain")
    val is_captain: Boolean,
    @SerializedName("Iskeeper")
    val is_keeper: Boolean,
    @SerializedName("Batting")
    val batting: Batting,
    @SerializedName("Bowling")
    val bowling: Bowling,
    var team_name: String,
)

data class Batting(
    @SerializedName("Style")
    val style: String,
    @SerializedName("Average")
    val average: String,
    @SerializedName("Strikerate")
    val strikeRate: String,
    @SerializedName("Runs")
    val runs: String,
)

data class Bowling(
    @SerializedName("Style")
    val style: String,
    @SerializedName("Average")
    val average: String,
    @SerializedName("Economyrate")
    val economy_rate: String,
    @SerializedName("Wickets")
    val wickets: String,
)