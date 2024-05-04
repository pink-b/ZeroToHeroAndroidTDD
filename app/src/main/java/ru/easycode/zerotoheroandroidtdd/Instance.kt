package ru.easycode.zerotoheroandroidtdd

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Instance(
    var text: String
): Parcelable