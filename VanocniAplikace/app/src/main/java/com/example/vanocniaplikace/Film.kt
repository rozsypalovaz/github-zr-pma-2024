package com.example.vanocniaplikace

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    val nazev: String,
    val zanr: String,
    val rok: Int,
    val popis: String,
    val obrazek: Int
) : Parcelable