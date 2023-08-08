package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.dtos.HotelierDTO
import com.trivago.accomodationlisting.services.HotelierService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/hotelier")
@Validated
class HotelierController(
    val hotelierService: HotelierService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addHotelier(@RequestBody @Valid hotelierDTO: HotelierDTO):HotelierDTO = hotelierService.createHotelier(hotelierDTO)

}