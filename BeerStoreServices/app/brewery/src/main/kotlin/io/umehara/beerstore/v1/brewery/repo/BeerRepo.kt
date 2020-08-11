package io.umehara.beerstore.v1.brewery.repo

import reactor.core.publisher.Flux

interface BeerRepo {
    fun getAllForBrewery(breweryId: Int): Flux<BeerSchema>
}