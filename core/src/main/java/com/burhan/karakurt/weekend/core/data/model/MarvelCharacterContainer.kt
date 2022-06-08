package com.burhan.karakurt.weekend.core.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MarvelCharacterContainer(@SerializedName("results") var results: ArrayList<MarvelCharacterModel>) :
    Parcelable