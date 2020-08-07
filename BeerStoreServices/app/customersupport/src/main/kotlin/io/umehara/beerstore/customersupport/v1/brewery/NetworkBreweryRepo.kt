package io.umehara.beerstore.customersupport.v1.brewery

import io.umehara.beerstore.customersupport.v1.brewery.model.Brewery
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.stereotype.Repository
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class NetworkBreweryRepo() : BreweryRepo {
    private val webClient = WebClient.create("http://localhost:7070/v1/")

    override fun getAll(): Flux<Brewery> {
        return webClient.get()
                .uri("breweries")
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Brewery::class.java)
    }

    override fun find(id: Int): Mono<Brewery> {
        return webClient.get()
                .uri("breweries/{id}", id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Brewery::class.java)
    }
}