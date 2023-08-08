package com.trivago.accomodationlisting.dtos

data class LocationDTO(

    val id:Int?,
    val city: String,
    val country: String,
    val zipcode: String,
    val address: String,

    val itemId:Int?=null
) {
}