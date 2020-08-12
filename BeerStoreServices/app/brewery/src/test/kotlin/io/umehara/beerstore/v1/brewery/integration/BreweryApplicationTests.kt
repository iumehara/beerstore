package io.umehara.beerstore.v1.brewery.integration

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest
class BreweryApplicationTests {
    lateinit var client: WebTestClient

    @BeforeEach
    fun setUp(context: ApplicationContext) {
        client = WebTestClient.bindToApplicationContext(context).build()
    }

    @Test
    fun breweries_index() {
        client.get().uri("/v1/breweries/")
                .exchange()
                .expectStatus().isOk
    }

    @Test
    fun breweries_show() {
        val idOfBreweryAssumedToBeSeededInDatabasePriorToTest = 1
        client.get().uri("/v1/breweries/$idOfBreweryAssumedToBeSeededInDatabasePriorToTest")
                .exchange()
                .expectStatus().isOk
    }
}
