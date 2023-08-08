package com.trivago.accomodationlisting.dtos

import com.trivago.accomodationlisting.annotations.*
import jakarta.validation.constraints.Size



data class ItemDTO(

    val id:Int?,

    @field:Size(min = 10, message = "itemDTO.name must be minimum of 10 characters")
    @field:ValidateItemDTOName
    val name:String,


    @field:ValidateItemDTORatingRange
    val rating: Int,

    @field:ValidateItemDTOCategory
    val category: String,

    @field:ValidateItemDTOImage
    val image: String,


    @field:ValidateItemDTOReputation
    val reputation:Int,

    val reputationBadge:String,
    val price:Int,
    val availability:Int,

    val hotelierId:Int? = null,

    val location : LocationDTO? = null
) {


}