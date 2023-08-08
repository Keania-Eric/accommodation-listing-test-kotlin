package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.dtos.ItemDTO
import com.trivago.accomodationlisting.services.ItemService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/items")
class ItemController(
    val itemService: ItemService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody itemDTO: ItemDTO): ItemDTO = itemService.addItem(itemDTO)
}