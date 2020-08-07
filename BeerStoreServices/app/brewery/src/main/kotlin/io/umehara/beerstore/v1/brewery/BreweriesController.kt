package io.umehara.beerstore.v1.brewery

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("v1/breweries")
class BreweriesController() {

    @GetMapping
    fun index(): Flux<Brewery> {
        return Flux.just(
                Brewery(1, "Asahi"),
                Brewery(2, "Kirin")
        )
    }

    @GetMapping("{id}")
    fun show(@PathVariable id: Int): Mono<Brewery> {
        return Mono.just(Brewery(1, "Asahi"))
    }
}