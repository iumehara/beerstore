package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.domain.Beer
import io.umehara.beerstore.v1.brewery.domain.Brewery
import io.umehara.beerstore.v1.brewery.domain.BreweryDetail
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class StubBreweryService : BreweryService {
    override fun getAll(): Flux<Brewery> {
        return Flux.just(
                Brewery(1, "Asahi"),
                Brewery(2, "Kirin"),
                Brewery(3, "Sapporo")
        )
    }

    override fun find(id: Int): Mono<BreweryDetail> {
        return Mono.just(
                BreweryDetail(
                        1,
                        "Asahi",
                        listOf(Beer(1, "Lager"), Beer(2, "Black"))
                )
        )
    }
}
