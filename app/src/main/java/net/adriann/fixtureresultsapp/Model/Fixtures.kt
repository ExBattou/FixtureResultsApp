package net.adriann.fixtureresultsapp.Model

import com.google.gson.annotations.SerializedName


data class Fixtures (

    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("homeTeam") val homeTeam : Team,
    @SerializedName("awayTeam") val awayTeam : Team,
    @SerializedName("date") val date : String,
    @SerializedName("competitionStage") val competitionStage : CompetitionStage,
    @SerializedName("venue") val venue : Venue,
    @SerializedName("state") val state : String

)