package net.adriann.fixtureresultsapp.Model

import com.google.gson.annotations.SerializedName


data class Team (

    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("shortName") val shortName : String,
    @SerializedName("abbr") val abbr : String,
    @SerializedName("alias") val alias : String
)

