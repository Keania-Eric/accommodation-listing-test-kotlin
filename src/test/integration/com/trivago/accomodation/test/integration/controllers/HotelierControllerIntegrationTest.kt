package com.trivago.accomodation.test.integration.controllers

import com.trivago.accomodationlisting.AccomodationlistingApplication
import com.trivago.accomodationlisting.dtos.HotelierDTO
import com.trivago.accomodationlisting.repositories.HotelierRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.reactive.server.WebTestClient
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest(classes = [AccomodationlistingApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
@ActiveProfiles("test")
@Testcontainers
class HotelierControllerIntegrationTest {

    @Autowired
    lateinit var webTestClient: WebTestClient

    companion object {

        @Container
        val postgresDB = PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:13-alpine")).apply {
            withDatabaseName("testdb")
            withUsername("postgres")
            withPassword("postgres")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgresDB::getJdbcUrl)
            registry.add("spring.datasource.username", postgresDB::getUsername)
            registry.add("spring.datasource.password", postgresDB::getPassword)
        }
    }


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