package net.adriann.fixtureresultsapp.Service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import net.adriann.fixtureresultsapp.Model.Fixtures
import net.adriann.fixtureresultsapp.Model.FixturesResponse
import net.adriann.fixtureresultsapp.Model.ResultsResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface FixtureResultsService {

    @GET("/cdn-og-test-api/test-task/results.json")
    fun getResults(): Deferred<ResultsResponse>

    @GET("/cdn-og-test-api/test-task/fixtures.json")
    fun getFixtures(): Deferred<FixturesResponse>

    companion object {

        fun createFixtureResultsService(): FixtureResultsService {

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://storage.googleapis.com")
                .build()


            return retrofit.create(FixtureResultsService::class.java)
        }
    }
}