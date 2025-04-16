package com.example.unscramble.data

import androidx.annotation.StringRes

data class Fruit(
    @StringRes val fruitResourceId: Int,
    @StringRes val fruitHint: Int
)
