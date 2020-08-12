package io.umehara.beerstore.v1.brewery

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.test.web.reactive.server.WebTestClient

class BreweriesControllerTest {
    private lateinit var stubBreweryService: StubBreweryService
    private lateinit var client: WebTestClient

    @BeforeEach
    fun setUp() {
        stubBreweryService = StubBreweryService()
        client = WebTestClient.bindToController(BreweriesController(stubBreweryService)).build()
    }

    @Test
    fun index() {
        val exchange = client.get().uri("/v1/breweries/").exchange()

        //language=JSON
        val expectedJson = "[\n  {\n    \"id\": 1,\n    \"name\": \"Asahi\"\n  },\n  {\n    \"id\": 2,\n    \"name\": \"Kirin\"\n  },\n  {\n    \"id\": 3,\n    \"name\": \"Sapporo\"\n  }\n]"
        exchange.expectStatus().isOk
                .expectBody().json(expectedJson)
    }

    @Test
    fun show() {
        val exchange = client.get().uri("/v1/breweries/1").exchange()

        //language=JSON
        val expectedJson = "{\n  \"id\": 1,\n  \"name\": \"Asahi\",\n  \"beers\": [\n    {\n      \"id\": 1,\n      \"name\": \"Lager\"\n    },\n    {\n      \"id\": 2,\n      \"name\": \"Black\"\n    }\n  ]\n}"
        exchange.expectStatus().isOk
                .expectBody().json(expectedJson)
    }
}