package com.trivago.accomodationlisting.services

import com.trivago.accomodationlisting.dtos.HotelierDTO
import com.trivago.accomodationlisting.entities.Hotelier
import com.trivago.accomodationlisting.repositories.HotelierRepository
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class HotelierService (
    val hotelierRepository: HotelierRepository
) {
    fun createHotelier(hotelierDTO: HotelierDTO): HotelierDTO {
        val hotelier = Hotelier(null, hotelierDTO.name)
        hotelierRepository.save(hotelier)

        return hotelier.let {
            HotelierDTO(it.id, it.name)
        }
    }


    fun findHotelierById(hotelierId:Int?): Optional<Hotelier> {
        return hotelierRepository.findById(hotelierId ?: 0)
    }


}