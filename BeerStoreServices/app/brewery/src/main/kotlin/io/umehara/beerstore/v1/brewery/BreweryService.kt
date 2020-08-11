package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.domain.Brewery
import io.umehara.beerstore.v1.brewery.domain.BreweryDetail
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BreweryService {
    fun getAll(): Flux<Brewery>
    fun find(id: Int): Mono<BreweryDetail>
}