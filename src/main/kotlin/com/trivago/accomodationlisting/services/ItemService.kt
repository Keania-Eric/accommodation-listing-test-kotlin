package com.trivago.accomodationlisting.services

import com.trivago.accomodationlisting.dtos.ItemDTO
import com.trivago.accomodationlisting.dtos.LocationDTO
import com.trivago.accomodationlisting.entities.Item
import com.trivago.accomodationlisting.entities.Location
import com.trivago.accomodationlisting.exceptions.HotelierNotValidException
import com.trivago.accomodationlisting.exceptions.ItemNotFoundException
import com.trivago.accomodationlisting.repositories.HotelierRepository
import com.trivago.accomodationlisting.repositories.ItemRepository
import com.trivago.accomodationlisting.repositories.LocationRepository
import mu.KLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional



@Service
class ItemService(
    val itemRepository: ItemRepository,
    val locationRepository: LocationRepository,
    val hotelierService: HotelierService
) {


    companion object : KLogging()

    fun addItem(itemDTO: ItemDTO): ItemDTO {



        val hotelierOptional = hotelierService.findHotelierById(itemDTO.hotelierId)

        if (! hotelierOptional.isPresent) {
            throw  HotelierNotValidException("Hotelier not valid: ${itemDTO.hotelierId}")
        }

        val item = itemDTO.let{
            Item(null, it.name, it.rating, it.category, it.image, it.reputation, it.reputationBadge, it.price, it.availability, hotelierOptional.get())
        }

        itemRepository.save(item)

        // save location
        val location  = itemDTO.location?.let{
            Location(null, it.city, it.state, it.country, it.zipcode, it.address, item)
        }

        val savedLocation = location?.let {
            locationRepository.save(it)
        }

        val locationDTO = savedLocation?.let{
            LocationDTO(it.id, it.city, it.state, it.country, it.zipcode, it.address)
        }


        return item.let {
            ItemDTO(it.id, it.name, it.rating, it.category, it.image, it.reputation, it.reputationBadge, it.price, it.availability, it.hotelier.id, locationDTO)
        }

    }


    fun getItemsForHotelier(hotelierId:Int) : List<ItemDTO?> {

        val items = itemRepository.findItemsByHotelierId(hotelierId)

        return items.map{ item ->

            val locationDTO = item.location?.let{
                LocationDTO(null, it.city, it.state, it.country, it.zipcode, it.address)
            }
            ItemDTO(item.id, item.name, item.rating, item.category, item.image, item.reputation, item.reputationBadge, item.price, item.availability, null, locationDTO)
        }
    }


    fun getItem(itemId:Int): ItemDTO {

        val itemOptional  = itemRepository.findById(itemId)


        return itemOptional.get().let{ item ->

            val locationDTO = item.location?.let{
                LocationDTO(null, it.city, it.state, it.country, it.zipcode, it.address)
            }

            ItemDTO(item.id, item.name, item.rating, item.category, item.image, item.reputation, item.reputationBadge, item.price, item.availability, null, locationDTO)
        }
    }


    fun deleteItem(itemId: Int) {
        val existingItem = itemRepository.findById(itemId)

        return if (existingItem.isPresent) {
            existingItem.get().let {
                itemRepository.deleteById(itemId)
            }
        }else {
            throw ItemNotFoundException("No item found for the supplied id: $itemId")
        }
    }
}