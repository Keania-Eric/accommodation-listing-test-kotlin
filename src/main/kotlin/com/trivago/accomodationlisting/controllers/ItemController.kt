package com.trivago.accomodationlisting.controllers

import com.trivago.accomodationlisting.dtos.ItemDTO
import com.trivago.accomodationlisting.services.ItemService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.validation.Validator
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/v1/items")
@Validated
class ItemController(
    val itemService: ItemService
) {

    @PostMapping("/{item_id}/book")
    fun bookItem(@PathVariable("item_id") itemId: Int) = itemService.bookItem(itemId)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addItem(@RequestBody @Valid itemDTO: ItemDTO): ItemDTO = itemService.addItem(itemDTO)

    @GetMapping("/{item_id}")
    fun getItem(@PathVariable("item_id") itemId:Int) : ItemDTO? = itemService.getItem(itemId)


    @PutMapping("/{item_id}")
    fun updateItem(@RequestBody @Valid itemDTO: ItemDTO, @PathVariable("item_id") itemId: Int) = itemService.updateItem(itemDTO, itemId)
    @DeleteMapping("/{item_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteItem(@PathVariable("item_id") itemId:Int)  = itemService.deleteItem(itemId)

    @GetMapping
    fun getItems(@RequestParam("hotelier_id", required = false) hotelierId:Int?): List<ItemDTO?> = itemService.getItems(hotelierId)
}