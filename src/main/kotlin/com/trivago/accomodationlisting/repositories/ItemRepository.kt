package com.trivago.accomodationlisting.repositories

import com.trivago.accomodationlisting.entities.Item
import org.springframework.data.repository.CrudRepository

interface ItemRepository: CrudRepository<Item, Int>{

    fun findItemsByHotelierId(hotelierId:Int): List<Item>
}