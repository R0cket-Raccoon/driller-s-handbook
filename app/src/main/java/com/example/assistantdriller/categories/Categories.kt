package com.example.assistantdriller.categories

import com.example.assistantdriller.R

class Categories {
    fun categories():List<CategoriesData>{
        return listOf<CategoriesData>(
            CategoriesData(R.drawable.gnvp,R.string.Газонефтеводопроявление,0),
            CategoriesData(R.drawable.pogloschenie,R.string.Поглощение,1),
            CategoriesData(R.drawable.prihvat,R.string.Прихват,2),
            CategoriesData(R.drawable.serovodorod,R.string.Сероводород,3),

        )
    }
}