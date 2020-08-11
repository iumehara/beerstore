package io.umehara.beerstore.v1.brewery

import io.umehara.beerstore.v1.brewery.domain.Beer
import io.umehara.beerstore.v1.brewery.domain.Brewery
import io.umehara.beerstore.v1.brewery.domain.BreweryDetail
import io.umehara.beerstore.v1.brewery.repo.BrewerySchema
import io.umehara.beerstore.v1.brewery.repo.BeerRepo
import io.umehara.beerstore.v1.brewery.repo.BreweryRepo
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DefaultBreweryService(val breweryRepo: BreweryRepo,
                            val beerRepo: BeerRepo
) : BreweryService {
    override fun getAll(): Flux<Brewery> {
        return breweryRepo.getAll().map { Brewery(it.id, it.name) }
    }

    override fun find(id: Int): Mono<BreweryDetail> {
        return breweryRepo
                .find(id)
                .flatMap { brewerySchema -> brewerySchemaToBreweryDetail(brewerySchema) }
    }

    private fun brewerySchemaToBreweryDetail(brewerySchema: BrewerySchema): Mono<BreweryDetail> {
        return beerRepo
                .getAllForBrewery(brewerySchema.id)
                .map { Beer(it.id, it.name) }
                .collectList()
                .map { beerList ->
                    BreweryDetail(
                            brewerySchema.id,
                            brewerySchema.name,
                            beerList
                    )
                }
    }
}