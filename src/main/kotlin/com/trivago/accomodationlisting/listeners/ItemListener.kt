package com.trivago.accomodationlisting.listeners

import com.trivago.accomodationlisting.entities.Item
import com.trivago.accomodationlisting.helpers.Utils
import jakarta.persistence.*

class ItemListener {
    @PrePersist
    fun prePersist(o: Item) {
        o.reputationBadge = Utils.getReputationBadge(o.reputation)
    }

    @PreUpdate
    fun preUpdate(o: Item) {
        o.reputationBadge = Utils.getReputationBadge(o.reputation)
    }

    @PreRemove
    fun preRemove(o: Item) {

    }

    @PostLoad
    fun postLoad(o: Item) {

    }

    @PostRemove
    fun postRemove(o: Item) {

    }

    @PostUpdate
    fun postUpdate(o: Item) {

    }

    @PostPersist
    fun postPersist(o: Item) {

    }
}