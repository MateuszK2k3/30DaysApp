package com.example.a30daysapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30daysapp.R

data class Plane(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)

val planes = listOf(
    Plane(R.string.plane_1_name, R.string.plane_1_description, R.drawable.plane_1),
    Plane(R.string.plane_2_name, R.string.plane_2_description, R.drawable.plane_2),
    Plane(R.string.plane_3_name, R.string.plane_3_description, R.drawable.plane_3),
    Plane(R.string.plane_4_name, R.string.plane_4_description, R.drawable.plane_4),
    Plane(R.string.plane_5_name, R.string.plane_5_description, R.drawable.plane_5),
    Plane(R.string.plane_6_name, R.string.plane_6_description, R.drawable.plane_6),
    Plane(R.string.plane_7_name, R.string.plane_7_description, R.drawable.plane_7),
    Plane(R.string.plane_8_name, R.string.plane_8_description, R.drawable.plane_8),
    Plane(R.string.plane_9_name, R.string.plane_9_description, R.drawable.plane_9),
    Plane(R.string.plane_10_name, R.string.plane_10_description, R.drawable.plane_10),
    Plane(R.string.plane_11_name, R.string.plane_11_description, R.drawable.plane_11),
    Plane(R.string.plane_12_name, R.string.plane_12_description, R.drawable.plane_12),
    Plane(R.string.plane_13_name, R.string.plane_13_description, R.drawable.plane_13),
    Plane(R.string.plane_14_name, R.string.plane_14_description, R.drawable.plane_10),
    Plane(R.string.plane_15_name, R.string.plane_15_description, R.drawable.plane_15),
    Plane(R.string.plane_16_name, R.string.plane_16_description, R.drawable.plane_16),
    Plane(R.string.plane_17_name, R.string.plane_17_description, R.drawable.plane_17),
    Plane(R.string.plane_18_name, R.string.plane_18_description, R.drawable.plane_18),
    Plane(R.string.plane_19_name, R.string.plane_19_description, R.drawable.plane_19),
    Plane(R.string.plane_20_name, R.string.plane_20_description, R.drawable.plane_20),
    Plane(R.string.plane_21_name, R.string.plane_21_description, R.drawable.plane_21),
    Plane(R.string.plane_22_name, R.string.plane_22_description, R.drawable.plane_22),
    Plane(R.string.plane_23_name, R.string.plane_23_description, R.drawable.plane_23),
    Plane(R.string.plane_24_name, R.string.plane_24_description, R.drawable.plane_24),
    Plane(R.string.plane_25_name, R.string.plane_25_description, R.drawable.plane_25),
    Plane(R.string.plane_26_name, R.string.plane_26_description, R.drawable.plane_26),
    Plane(R.string.plane_27_name, R.string.plane_27_description, R.drawable.plane_27),
    Plane(R.string.plane_28_name, R.string.plane_28_description, R.drawable.plane_28),
    Plane(R.string.plane_29_name, R.string.plane_29_description, R.drawable.plane_29),
    Plane(R.string.plane_30_name, R.string.plane_30_description, R.drawable.plane_30)
)
