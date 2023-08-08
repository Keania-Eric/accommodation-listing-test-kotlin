package com.trivago.accomodationlisting.dtos



data class ItemDTO(

    val id:Int?,
    val name:String?,
    val category: String?,
    val image: String,
    val reputation:Int,
    val reputationBadge:String,
    val price:Int,
    val availability:Int,

    val hotelierId:Int? = null
) {
}