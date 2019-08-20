package net.adriann.fixtureresultsapp.UI.Fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_results.*
import net.adriann.fixtureresultsapp.Adapter.ResultsAdapter
import net.adriann.fixtureresultsapp.Model.Results
import net.adriann.fixtureresultsapp.R
import net.adriann.fixtureresultsapp.ViewModel.ResultsViewModel

class ResultsFragment : Fragment() {


    var resultsViewModel: ResultsViewModel? = null
    var resultsAdapter: ResultsAdapter? = null

    private var mContext: Context? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = context
        resultsViewModel =  ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        getResults()
    }

    fun getResults() {
        resultsViewModel!!.getResults().observe(this, Observer<List<Results>> { fixtureList ->
            prepareRecyclerView(fixtureList)
        })
    }

    private fun prepareRecyclerView(fixtureList: List<Results>) {
        resultsAdapter = ResultsAdapter(fixtureList)
        results_recycler.setLayoutManager(LinearLayoutManager(mContext))
        results_recycler.setItemAnimator(DefaultItemAnimator())
        results_recycler.setAdapter(resultsAdapter)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }


    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ResultsFragment().apply {

            }
    }
}
