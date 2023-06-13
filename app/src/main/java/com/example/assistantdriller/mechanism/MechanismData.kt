package com.example.assistantdriller.mechanism

import androidx.annotation.IdRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class MechanismData(
    @StringRes val Question:Int,
    @StringRes val answer_1:Int,
    @StringRes val answer_2:Int,
    @StringRes val answer_3:Int,
    val number:Int,


)


