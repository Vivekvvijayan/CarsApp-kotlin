package com.example.carsapp.modal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize



data class CarsModel(
    var Results:List<Data>
)

@Parcelize
data class Data(
    var Country:String,
    var Mfr_CommonName:String,
    var Mfr_ID:Int,
    var Mfr_Name:String,
    var vehicleTypes:List<VType>
):Parcelable

@Parcelize
data class VType(
    var IsPrimary:Boolean,
    var Name:String
):Parcelable