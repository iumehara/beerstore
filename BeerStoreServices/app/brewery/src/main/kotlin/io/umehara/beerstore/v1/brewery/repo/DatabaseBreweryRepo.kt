package io.umehara.beerstore.v1.brewery.repo

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class DatabaseBreweryRepo : BreweryRepo {
    override fun getAll(): Flux<BrewerySchema> {
        return Flux.just(
                BrewerySchema(1, "Asahi"),
                BrewerySchema(2, "Kirin")
        )
    }

    override fun find(id: Int): Mono<BrewerySchema> {
        return Mono.just(BrewerySchema(1, "Asahi"))
    }
}