package net.adriann.fixtureresultsapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.adriann.fixtureresultsapp.Model.Results
import net.adriann.fixtureresultsapp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ResultsAdapter(private val list: List<Results>)
    : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ResultsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        var results: Results = list[position]
        holder.bind(results)
    }

    override fun getItemCount(): Int = list.size

    class ResultsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_result, parent, false)) {

        var awayteam_result: TextView? = null
        var homeTeam_result: TextView? = null
        var competition_result: TextView? = null
        var stadiumName_result: TextView? = null
        var venueDate_result: TextView? = null
        var homeScore_result: TextView? = null
        var awayScore_result: TextView? = null

        init {
            awayteam_result = itemView.findViewById(R.id.away_team_result)
            homeTeam_result = itemView.findViewById(R.id.home_team_result)
            competition_result = itemView.findViewById(R.id.competition_name_result)
            stadiumName_result = itemView.findViewById(R.id.stadium_name_result)
            venueDate_result = itemView.findViewById(R.id.competition_date_result)
            homeScore_result = itemView.findViewById(R.id.home_score_result)
            awayScore_result = itemView.findViewById(R.id.away_score_result)

        }

        @SuppressLint("ResourceAsColor")
        fun bind(results: Results) {
            awayteam_result?.text = results.awayTeam.name
            homeTeam_result?.text = results.homeTeam.name

            competition_result?.text = results.competitionStage.competition.name
            stadiumName_result?.text = results.venue.name + " | "
            venueDate_result?.text =  dateTimeFormatterGetDateFormatted(results.date)
            homeScore_result?.text = results.score.home.toString()
            awayScore_result?.text = results.score.away.toString()

            if (results.score.winner != null ) {
                if(results.score.winner.equals("away")) {
                    awayScore_result?.setTextColor(R.color.colorAccent)
                }

                if(results.score.winner.equals("home")) {
                    homeScore_result?.setTextColor(R.color.colorAccent)
                }
            }


        }
        fun dateTimeFormatterGetDateFormatted(aDate:String):String  {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val date = LocalDate.parse(aDate, formatter)
            return date.toString()
        }
    }


}