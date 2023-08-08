package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.services.ItemService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/items")
class ItemController(
    val itemService: ItemService
) {
}