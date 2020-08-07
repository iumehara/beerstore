package io.umehara.beerstore.customersupport.v1.brewery

import io.umehara.beerstore.customersupport.v1.brewery.model.Brewery
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class DefaultBreweryService(val breweryRepo: BreweryRepo) : BreweryService {
    override fun getAll(): Flux<Brewery> {
        return breweryRepo.getAll()
    }

    override fun find(id: Int): Mono<Brewery> {
        return breweryRepo.find(id)
    }
}