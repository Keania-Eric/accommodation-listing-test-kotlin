package com.trivago.accomodationlisting.entities

import jakarta.persistence.*

@Entity
@Table(name = "Locations")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    val city: String = "",
    val state: String = "",
    val country: String = "",
    val zipcode: String = "",
    val address: String = "",

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    val item: Item? = null
) {
    constructor() : this(null)
}
