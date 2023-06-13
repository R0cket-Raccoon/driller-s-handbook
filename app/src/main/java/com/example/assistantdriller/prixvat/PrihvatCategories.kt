package com.example.assistantdriller.prixvat

import com.example.assistantdriller.R
import com.example.assistantdriller.gnvp.GNVPData

class PrihvatCategories {
    fun prihvatCategories(): List<GNVPData> {
        return listOf(
            GNVPData(R.string.Prihvat, R.string.PreventionMeasuresPrihvat,false),
            GNVPData(R.string.LiquidationPrihvat, R.string.ListOfLiquidationPrihvat,false),
            GNVPData(R.string.DiffPrihvat, R.string.ListOfDiffPrihvat,false),
            GNVPData(R.string.SlamPrihvat, R.string.ListOfSlamPrihvat,false),
            GNVPData(R.string.GeomPrihvat, R.string.ListOFGeomPrihvat,false),
            GNVPData(R.string.OKPrihvat, R.string.ListOfOKPrihvat,false),
            GNVPData(R.string.OKDiffPrihvat, R.string.ListOfOKDiffPrihvat,false),
            GNVPData(R.string.SpuskGeomPrihvat, R.string.ListOFSpuskGeomPrihvat,false),
            GNVPData(R.string.OKPorodaPrihvat, R.string.ListOfOKPorodaPrihvat,false),
        )
    }
}