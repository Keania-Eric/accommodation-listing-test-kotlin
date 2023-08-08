package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.services.HotelierService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("v1/hotelier")
class HotelierController(
    val hotelierService: HotelierService
) {
}