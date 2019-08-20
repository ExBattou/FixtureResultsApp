package net.adriann.fixtureresultsapp.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import net.adriann.fixtureresultsapp.Model.Fixtures
import net.adriann.fixtureresultsapp.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class FixturesAdapter (private val list: List<Fixtures>)
    : RecyclerView.Adapter<FixturesAdapter.FixtureViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return FixtureViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        var fixture: Fixtures = list[position]
        holder.bind(fixture)
    }

    override fun getItemCount(): Int = list.size

    class FixtureViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_fixture, parent, false)) {

        var homeTeam: TextView? = null
        var awayTeam: TextView? = null
        var competition: TextView? = null
        var stadiumName: TextView? = null
        var venueDate: TextView? = null
        var dateNumber: TextView? = null
        var dateDay: TextView? = null
        var postponed: TextView? = null

        init {
            homeTeam = itemView.findViewById(R.id.home_team)
            awayTeam = itemView.findViewById(R.id.away_team)
            competition = itemView.findViewById(R.id.competition_name)
            stadiumName = itemView.findViewById(R.id.stadium_name)
            venueDate = itemView.findViewById(R.id.competition_date)
            dateNumber = itemView.findViewById(R.id.date_number)
            dateDay = itemView.findViewById(R.id.date_day)
            postponed = itemView.findViewById(R.id.postponed_label)
        }

        fun bind(fixtures: Fixtures) {
            homeTeam?.text = fixtures.homeTeam.name
            awayTeam?.text = fixtures.awayTeam.name
            competition?.text = fixtures.competitionStage.competition.name
            stadiumName?.text = fixtures.venue.name + " | "
            venueDate?.text =  dateTimeFormatterGetDateFormatted(fixtures.date)
            dateNumber?.text = dateTimeFormatterGetDayNumber(fixtures.date)
            dateDay?.text = dateTimeFormatterGetDayOfTheWeek(fixtures.date).subSequence(0,3)
            if(fixtures.state!= null) {
                if(fixtures.state?.equals("postponed")){
                    postponed?.visibility = View.VISIBLE

                } else {
                    postponed?.visibility = View.GONE
                }
            }
        }

        fun dateTimeFormatterGetDayNumber(aDate:String):String  {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val date = LocalDate.parse(aDate, formatter)
            return date.dayOfMonth.toString()
        }
        fun dateTimeFormatterGetDayOfTheWeek(aDate:String):String  {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val date = LocalDate.parse(aDate, formatter)
            return date.dayOfWeek.toString()
        }

        fun dateTimeFormatterGetDateFormatted(aDate:String):String  {
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH)
            val date = LocalDate.parse(aDate, formatter)
            return date.toString()
        }
    }




}