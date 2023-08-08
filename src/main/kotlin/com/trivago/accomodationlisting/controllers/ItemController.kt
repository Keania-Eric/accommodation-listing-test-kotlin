package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.dtos.ItemDTO
import com.trivago.accomodationlisting.services.ItemService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/items")
class ItemController(
    val itemService: ItemService
) {


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody itemDTO: ItemDTO): ItemDTO = itemService.addItem(itemDTO)

    @GetMapping("/{item_id}")
    fun getItem(@PathVariable("item_id") itemId:Int) : ItemDTO? = itemService.getItem(itemId)

    @DeleteMapping("/{item_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteItem(@PathVariable("item_id") itemId:Int)  = itemService.deleteItem(itemId)

    @GetMapping("/hotelier/{hotelier_id}")
    fun getItemsForHotelier(@PathVariable("hotelier_id") hotelierId:Int): List<ItemDTO?> = itemService.getItemsForHotelier(hotelierId)
}