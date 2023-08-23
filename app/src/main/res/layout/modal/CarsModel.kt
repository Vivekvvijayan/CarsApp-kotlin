package com.example.carapp.modal

data class CarsModel(
    var Results:List<Data>
)


data class Data(
    var Country:String,
    var Mfr_CommonName:String,
    var Mfr_ID:Int,
    var Mfr_Name:String,
    var vehicleTypes:List<VType>
)

data class VType(
    var IsPrimary:Boolean,
    var Name:String
)