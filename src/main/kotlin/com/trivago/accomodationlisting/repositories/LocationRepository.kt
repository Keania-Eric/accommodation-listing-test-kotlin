package com.trivago.accomodationlisting.repositories

import com.trivago.accomodationlisting.entities.Location
import org.springframework.data.repository.CrudRepository

interface LocationRepository: CrudRepository<Location, Int> {
}