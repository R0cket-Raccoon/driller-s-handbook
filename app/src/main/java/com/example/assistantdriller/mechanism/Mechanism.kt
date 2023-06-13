package com.example.assistantdriller.mechanism

import com.example.assistantdriller.R

class Mechanism {
    fun mechanism():List<MechanismData>{
        return listOf<MechanismData>(
            MechanismData(R.string.Question1,R.string.Question1_1,R.string.Question1_2,R.string.Question1_3,0,),
            MechanismData(R.string.Question2,R.string.Question2_1,R.string.Question2_2,R.string.Question2_3,1,),
            MechanismData(R.string.Question3,R.string.Question3_1,R.string.Question3_2,R.string.Question3_3,2,),
            MechanismData(R.string.Question4,R.string.Question4_1,R.string.Question4_2,R.string.Question4_3,3,),
        )
    }
}