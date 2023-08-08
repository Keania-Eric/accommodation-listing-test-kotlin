package com.trivago.accomodationlisting.repositories

import com.trivago.accomodationlisting.entities.Hotelier
import org.springframework.data.repository.CrudRepository

interface HotelierRepository: CrudRepository<Hotelier, Int> {
}