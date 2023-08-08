package com.trivago.accomodationlisting.entities

import jakarta.persistence.*

@Entity
@Table(name = "items")
data class Item(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id:Int?,

    val name:String,
    val rating: Int,
    val category: String,
    val image:String,
    val reputation:Int,
    val reputationBadge:String,
    val price:Int,
    val availability:Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotelier_id", nullable = false)
    val hotelier: Hotelier,

    @OneToOne(
        mappedBy = "item"
    )
    val location: Location? = null
) {
}