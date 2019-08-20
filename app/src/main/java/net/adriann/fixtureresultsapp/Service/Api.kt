package net.adriann.fixtureresultsapp.Service

import kotlinx.coroutines.Deferred
import net.adriann.fixtureresultsapp.Model.Fixtures
import net.adriann.fixtureresultsapp.Model.FixturesResponse
import net.adriann.fixtureresultsapp.Model.Results
import net.adriann.fixtureresultsapp.Model.ResultsResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    val BASE_URL: String
        get() = "https://storage.googleapis.com/"


    @GET("/cdn-og-test-api/test-task/fixtures.json")
    fun getFixtures(): Call<List<Fixtures>>

    @GET("/cdn-og-test-api/test-task/results.json")
    fun getResults(): Call<List<Results>>
}