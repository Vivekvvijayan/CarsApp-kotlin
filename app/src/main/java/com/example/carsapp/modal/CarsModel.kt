package com.example.carsapp.modal

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CarsModel(
    var Results: List<Data>
)

@Parcelize
data class Data(
    var Country: String,
    var Mfr_CommonName: String,
    var Mfr_ID: Int,
    var Mfr_Name: String,
    var VehicleTypes: List<VType>
) : Parcelable

@Parcelize
data class VType(
    var Name: String
) : Parcelable