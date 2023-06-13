package com.example.assistantdriller.h2s

import com.example.assistantdriller.R
import com.example.assistantdriller.gnvp.GNVPData

class H2SCategories {
    fun h2sCategories(): List<GNVPData> {
        return listOf(
            GNVPData(R.string.EventsH2S, R.string.ListOfEventsH2S, false),
            GNVPData(R.string.ControlMethodsH2S, R.string.ListOfControlMethodsH2S, false),
            GNVPData(R.string.NeutralizationH2S, R.string.ListOfNeutralizationH2S, false),
            GNVPData(R.string.HumanImpactH2S, R.string.ListOfHumanImpactH2S, false),
        )
    }

}