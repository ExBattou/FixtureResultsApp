package net.adriann.fixtureresultsapp.Model

import com.google.gson.annotations.SerializedName



data class Score (

	@SerializedName("home") val home : Int,
	@SerializedName("away") val away : Int,
	@SerializedName("winner") val winner : String
)