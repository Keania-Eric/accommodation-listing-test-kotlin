package com.trivago.accomodationlisting.helpers

object Utils {

    fun getReputationBadge(reputation: Int?): String {
        if (reputation == null) {
            return ""
        }



        if (reputation <= 500) {
            return "red"
        }

        if (reputation > 500 && reputation <= 799) {
            return "yellow"
        }

        return "green"
    }
}