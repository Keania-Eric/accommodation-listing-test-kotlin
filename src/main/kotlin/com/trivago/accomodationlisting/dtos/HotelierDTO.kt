package com.trivago.accomodationlisting.dtos

import jakarta.validation.constraints.NotBlank

data class HotelierDTO(

    val id:Int?,

    @get:NotBlank(message="hotelierDTO.name must not be blank")
    val name: String
) {
}