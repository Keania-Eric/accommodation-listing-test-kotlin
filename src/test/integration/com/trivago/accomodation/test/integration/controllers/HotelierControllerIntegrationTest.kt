package com.trivago.accomodation.test.integration.controllers

import com.trivago.accomodation.test.integration.utils.BaseIntegrationTest
import com.trivago.accomodationlisting.dtos.HotelierDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test



class HotelierControllerIntegrationTest: BaseIntegrationTest(){

    @Test
    fun addInstructor() {
        val hotelierDTO: HotelierDTO = HotelierDTO(null, "James Cameron")
        val hotelier = webTestClient.post()
            .uri("v1/hotelier")
            .bodyValue(hotelierDTO)
            .exchange()
            .expectStatus().isCreated
            .expectBody(hotelierDTO::class.java)
            .returnResult()
            .responseBody

        Assertions.assertNotNull(hotelier?.id)
        Assertions.assertEquals(hotelierDTO.name, hotelier?.name)
    }
}