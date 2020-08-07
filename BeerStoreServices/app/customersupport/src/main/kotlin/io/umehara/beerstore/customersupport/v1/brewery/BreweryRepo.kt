package io.umehara.beerstore.customersupport.v1.brewery

import io.umehara.beerstore.customersupport.v1.brewery.model.Brewery
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface BreweryRepo {
    fun getAll(): Flux<Brewery>
    fun find(id: Int): Mono<Brewery>
}
