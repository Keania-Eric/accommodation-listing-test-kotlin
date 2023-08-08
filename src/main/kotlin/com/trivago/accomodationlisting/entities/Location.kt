package com.trivago.accomodationlisting.entities

import jakarta.persistence.*

@Entity
@Table(name = "Locations")
data class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    var city: String = "",
    var state: String = "",
    var country: String = "",
    var zipcode: String = "",
    var address: String = "",

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    var item: Item? = null
) {
    constructor() : this(null)
}
