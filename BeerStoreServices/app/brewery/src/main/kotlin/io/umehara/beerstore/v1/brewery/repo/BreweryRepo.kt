package io.umehara.beerstore.v1.brewery.repo

import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BreweryRepo {
    fun getAll(): Flux<BrewerySchema>
    fun find(id: Int): Mono<BrewerySchema>
}