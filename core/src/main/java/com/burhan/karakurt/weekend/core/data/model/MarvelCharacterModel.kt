package com.burhan.karakurt.weekend.core.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize


@Parcelize
data class MarvelCharacterModel(
    @SerializedName("name") var name: String?,
    @SerializedName("thumbnail") var thumbnail: ThumbnailModel?
) : Parcelable

@Parcelize
data class ThumbnailModel(
    @SerializedName("path") var path: String,
    @SerializedName("extension") var extension: String
) : Parcelable {
    override fun toString(): String {
        return "$path/standard_fantastic.$extension"
    }
}


