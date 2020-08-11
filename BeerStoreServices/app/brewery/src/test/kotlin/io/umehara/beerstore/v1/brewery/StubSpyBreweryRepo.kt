@file:Suppress("PropertyName")

package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.repo.BreweryRepo
import io.umehara.beerstore.v1.brewery.repo.BrewerySchema
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class StubSpyBreweryRepo : BreweryRepo {
    var getAll_called = false
    override fun getAll(): Flux<BrewerySchema> {
        getAll_called = true
        return Flux.just(
                BrewerySchema(11, "Stub Brewery A"),
                BrewerySchema(12, "Stub Brewery B"),
                BrewerySchema(13, "Stub Brewery C")
        )
    }

    var find_calledWith_id: Int? = null
    override fun find(id: Int): Mono<BrewerySchema> {
        find_calledWith_id = id
        return Mono.just(BrewerySchema(11, "Stub Brewery A"))
    }
}
