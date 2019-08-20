package net.adriann.fixtureresultsapp.ViewModel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import net.adriann.fixtureresultsapp.Model.Fixtures
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import net.adriann.fixtureresultsapp.Service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.lifecycle.MutableLiveData
import net.adriann.fixtureresultsapp.Model.FixturesResponse


class FixturesViewModel : ViewModel() {

    private var fixturesList: MutableLiveData<List<Fixtures>>? = null



    fun getFixtures(): LiveData<List<Fixtures>> {
        //if the list is null
        if (fixturesList == null) {
            fixturesList = MutableLiveData<List<Fixtures>>()
            //we will load it asynchronously from server in this method
            loadEverythingFixtures()
        }

        //finally we will return the list
        return fixturesList as MutableLiveData<List<Fixtures>>
    }

    fun loadEverythingFixtures() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://storage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getFixtures()

        call.enqueue(object : Callback<List<Fixtures>> {
            override fun onFailure(call: Call<List<Fixtures>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Fixtures>>, response: Response<List<Fixtures>>) {
                fixturesList!!.value = response.body()
            }


        })
    }
}
