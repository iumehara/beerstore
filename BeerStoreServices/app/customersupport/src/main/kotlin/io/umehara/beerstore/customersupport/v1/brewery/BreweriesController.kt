package io.umehara.beerstore.customersupport.v1.brewery

import io.umehara.beerstore.customersupport.v1.brewery.model.Brewery
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("v1/breweries")
class BreweriesController(val breweryService: BreweryService) {

    @GetMapping
    fun index(): Flux<Brewery> {
        return breweryService.getAll()
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Int): Mono<Brewery> {
        return breweryService.find(id)
    }
}