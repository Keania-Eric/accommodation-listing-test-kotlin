package com.trivago.accomodationlisting.services

import com.trivago.accomodationlisting.repositories.ItemRepository
import com.trivago.accomodationlisting.repositories.LocationRepository
import org.springframework.stereotype.Service


@Service
class LocationService(
    val locationRepository: LocationRepository,
    val itemRepository: ItemRepository
) {
}