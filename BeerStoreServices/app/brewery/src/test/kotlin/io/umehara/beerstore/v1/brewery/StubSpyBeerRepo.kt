package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.repo.BeerSchema
import io.umehara.beerstore.v1.brewery.repo.BeerRepo
import reactor.core.publisher.Flux

@Suppress("PropertyName")
class StubSpyBeerRepo : BeerRepo {
    var getAllForBrewery_calledWith_breweryId: Int? = null
    override fun getAllForBrewery(breweryId: Int): Flux<BeerSchema> {
        getAllForBrewery_calledWith_breweryId = breweryId
        return Flux.just(
                BeerSchema(1, "Stub Beer A", 11),
                BeerSchema(2, "Stub Beer B", 11),
                BeerSchema(3, "Stub Beer C", 11)
        )
    }
}
