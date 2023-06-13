package com.example.assistantdriller.categories

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CategoriesData(
    @DrawableRes val categoriesImage:Int,
    @StringRes val categoriesString: Int,
    val number: Int,
){}