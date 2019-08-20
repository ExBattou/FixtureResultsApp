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
import kotlinx.android.synthetic.main.fragment_fixtures.*
import net.adriann.fixtureresultsapp.Adapter.FixturesAdapter
import net.adriann.fixtureresultsapp.Model.Fixtures
import net.adriann.fixtureresultsapp.ViewModel.FixturesViewModel




class FixturesFragment : Fragment() {

    var fixturesViewModel: FixturesViewModel? = null
    var fixturesAdapter: FixturesAdapter? = null

    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = context
        fixturesViewModel =  ViewModelProviders.of(this).get(FixturesViewModel::class.java)
        getFixtures()
    }

    fun getFixtures() {
        fixturesViewModel!!.getFixtures().observe(this, Observer<List<Fixtures>> { fixtureList ->
            prepareRecyclerView(fixtureList)
        })
    }

     private fun prepareRecyclerView(fixtureList: List<Fixtures>) {
         fixturesAdapter = FixturesAdapter(fixtureList)
         fixtures_recycler.setLayoutManager(LinearLayoutManager(mContext))
         fixtures_recycler.setItemAnimator(DefaultItemAnimator())
         fixtures_recycler.setAdapter(fixturesAdapter)
     }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(net.adriann.fixtureresultsapp.R.layout.fragment_fixtures, container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onDetach() {
        super.onDetach()

    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            FixturesFragment().apply {

            }
    }
}
