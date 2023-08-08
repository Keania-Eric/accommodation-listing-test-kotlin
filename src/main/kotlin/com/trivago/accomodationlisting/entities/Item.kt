package com.trivago.accomodationlisting.entities

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = null,

    val name: String = "",
    val rating: Int = 0,
    val category: String = "",
    val image: String = "",
    val reputation: Int = 0,
    val reputationBadge: String = "",
    val price: Int = 0,
    val availability: Int = 0,

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
