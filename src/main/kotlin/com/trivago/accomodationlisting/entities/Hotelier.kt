package com.trivago.accomodationlisting.entities

import jakarta.persistence.*


@Entity
@Table(name = "hoteliers")
data class Hotelier(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int?,

    val name:String,

    @OneToMany(
        mappedBy = "hotelier",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )

    var items:List<Item> = mutableListOf()
) {

    constructor() : this(null, "", emptyList()) // Default constructor

}