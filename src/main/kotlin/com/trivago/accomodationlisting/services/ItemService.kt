package com.trivago.accomodationlisting.services

import com.trivago.accomodationlisting.repositories.HotelierRepository
import com.trivago.accomodationlisting.repositories.ItemRepository
import org.springframework.stereotype.Service

@Service
class ItemService(
    val itemRepository: ItemRepository,
    val hotelierRepository: HotelierRepository
) {
}