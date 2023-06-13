package com.example.assistantdriller.pogloschenie

import com.example.assistantdriller.R
import com.example.assistantdriller.gnvp.GNVPData

class PogloschenieCategories {
    fun pogloschenieCategories(): List<GNVPData> {
        return listOf(
            GNVPData(R.string.Slightly,R.string.SlightlyLiquidation,false),
            GNVPData(R.string.Partial,R.string.PartialLiquidation,false),
            GNVPData(R.string.Average,R.string.AverageLiquidation,false),
            GNVPData(R.string.Full,R.string.FullLiquidation,false),
            GNVPData(R.string.Prevention,R.string.PreventionActions,false),
        )}
}