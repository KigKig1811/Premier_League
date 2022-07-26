package com.example.manchesterunited.model.topScorerNew


data class TopScorersPlayerNews(
    val errors: List<Any?>? = listOf(),
    val `get`: String? = "",
    val paging: Paging? = Paging(),
    val parameters: Parameters? = Parameters(),
    val response: List<Response?>? = listOf(),
    val results: Int? = 0
) {
    data class Paging(
        val current: Int? = 0,
        val total: Int? = 0
    )

    data class Parameters(
        val league: String? = "",
        val season: String? = ""
    )

    data class Response(
        val player: Player? = Player(),
        val statistics: List<Statistic?>? = listOf()
    ) {
        data class Player(
            val age: Int? = 0,
            val birth: Birth? = Birth(),
            val firstname: String? = "",
            val height: String? = "",
            val id: Int? = 0,
            val injured: Boolean? = false,
            val lastname: String? = "",
            val name: String? = "",
            val nationality: String? = "",
            val photo: String? = "",
            val weight: String? = ""
        ) {
            data class Birth(
                val country: String? = "",
                val date: String? = "",
                val place: String? = ""
            )
        }

        data class Statistic(
            val cards: Cards? = Cards(),
            val dribbles: Dribbles? = Dribbles(),
            val duels: Duels? = Duels(),
            val fouls: Fouls? = Fouls(),
            val games: Games? = Games(),
            val goals: Goals? = Goals(),
            val league: League? = League(),
            val passes: Passes? = Passes(),
            val penalty: Penalty? = Penalty(),
            val shots: Shots? = Shots(),
            val substitutes: Substitutes? = Substitutes(),
            val tackles: Tackles? = Tackles(),
            val team: Team? = Team()
        ) {
            data class Cards(
                val red: Int? = 0,
                val yellow: Int? = 0,
                val yellowred: Int? = 0
            )

            data class Dribbles(
                val attempts: Int? = 0,
                val past: Any? = Any(),
                val success: Int? = 0
            )

            data class Duels(
                val total: Int? = 0,
                val won: Int? = 0
            )

            data class Fouls(
                val committed: Int? = 0,
                val drawn: Int? = 0
            )

            data class Games(
                val appearences: Int? = 0,
                val captain: Boolean? = false,
                val lineups: Int? = 0,
                val minutes: Int? = 0,
                val number: Any? = Any(),
                val position: String? = "",
                val rating: String? = ""
            )

            data class Goals(
                val assists: Int? = 0,
                val conceded: Any? = Any(),
                val saves: Any? = Any(),
                val total: Int? = 0
            )

            data class League(
                val country: String? = "",
                val flag: String? = "",
                val id: Int? = 0,
                val logo: String? = "",
                val name: String? = "",
                val season: Int? = 0
            )

            data class Passes(
                val accuracy: Int? = 0,
                val key: Int? = 0,
                val total: Int? = 0
            )

            data class Penalty(
                val commited: Int? = 0,
                val missed: Int? = 0,
                val saved: Any? = Any(),
                val scored: Int? = 0,
                val won: Int? = 0
            )

            data class Shots(
                val on: Int? = 0,
                val total: Int? = 0
            )

            data class Substitutes(
                val bench: Int? = 0,
                val `in`: Int? = 0,
                val `out`: Int? = 0
            )

            data class Tackles(
                val blocks: Int? = 0,
                val interceptions: Int? = 0,
                val total: Int? = 0
            )

            data class Team(
                val id: Int? = 0,
                val logo: String? = "",
                val name: String? = ""
            )
        }
    }
}