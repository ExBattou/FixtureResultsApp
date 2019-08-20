package net.adriann.fixtureresultsapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.adriann.fixtureresultsapp.Model.Results
import net.adriann.fixtureresultsapp.Model.ResultsResponse
import net.adriann.fixtureresultsapp.Service.Api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResultsViewModel() : ViewModel() {



    private var resultList: MutableLiveData<List<Results>>? = null

    fun getResults(): LiveData<List<Results>> {
        //if the list is null
        if (resultList == null) {
            resultList = MutableLiveData<List<Results>>()
            //we will load it asynchronously from server in this method
            loadEverythingResults()
        }

        //finally we will return the list
        return resultList as MutableLiveData<List<Results>>
    }

    fun loadEverythingResults() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://storage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getResults()

        call.enqueue(object : Callback<List<Results>> {
            override fun onFailure(call: Call<List<Results>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                resultList!!.value = response.body()
            }


        })
    }
}