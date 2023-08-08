package com.trivago.accomodationlisting.services

import com.trivago.accomodationlisting.repositories.HotelierRepository
import org.springframework.stereotype.Service

@Service
class HotelierService (
    val hotelierRepository: HotelierRepository
) {
}