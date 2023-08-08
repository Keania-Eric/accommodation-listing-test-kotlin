package com.trivago.accomodationlisting.entities

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    var name: String = "",
    var rating: Int = 0,
    var category: String = "",
    var image: String = "",
    var reputation: Int = 0,
    var reputationBadge: String = "",
    var price: Int = 0,
    var availability: Int = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelier_id", nullable = false)
    val hotelier: Hotelier = Hotelier(),

    @OneToOne(
        mappedBy = "item",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    val location: Location? = null
) {
    constructor() : this(null)
}
