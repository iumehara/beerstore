package io.umehara.beerstore.v1.brewery.repo

import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
class DatabaseBeerRepo: BeerRepo {
    override fun getAllForBrewery(breweryId: Int): Flux<BeerSchema> {
        return Flux.just(BeerSchema(0, "", 0))
    }
}